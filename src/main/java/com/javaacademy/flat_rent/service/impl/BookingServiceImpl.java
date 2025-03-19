package com.javaacademy.flat_rent.service.impl;

import com.javaacademy.flat_rent.dto.AdvertDtoRq;
import com.javaacademy.flat_rent.dto.BookingDtoRq;
import com.javaacademy.flat_rent.dto.BookingDtoRsp;
import com.javaacademy.flat_rent.dto.ClientDto;
import com.javaacademy.flat_rent.entity.Advert;
import com.javaacademy.flat_rent.entity.Booking;
import com.javaacademy.flat_rent.entity.Client;
import com.javaacademy.flat_rent.exception.AdvertNotFoundException;
import com.javaacademy.flat_rent.exception.ClientNotFoundException;
import com.javaacademy.flat_rent.exception.DateRangeIntersectionException;
import com.javaacademy.flat_rent.mapper.BookingMapper;
import com.javaacademy.flat_rent.mapper.ClientMapper;
import com.javaacademy.flat_rent.repository.AdvertRepository;
import com.javaacademy.flat_rent.repository.BookingRepository;
import com.javaacademy.flat_rent.repository.ClientRepository;
import com.javaacademy.flat_rent.service.api.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {
    public static final int FIRST_PAGE = 0;
    public static final int TWENTY_ENTRIES = 20;
    public static final String ORDER_BY_PRICE = "email";
    private final BookingMapper bookingMapper;
    private final BookingRepository bookingRepository;
    private final AdvertRepository advertRepository;
    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    @Override
    public Page<BookingDtoRsp> getBookingsByEmail(String email, Integer page, Integer size) {
        int numberPage = page == null ? FIRST_PAGE : page;
        int sizePage = size == null ? TWENTY_ENTRIES : size;

        PageRequest pageRequest = PageRequest.of(numberPage, sizePage);
        Page<Booking> bookings= bookingRepository.findByClientEmail(email, pageRequest);
        Page<BookingDtoRsp> bookingDtoRsp = bookings.map(booking -> bookingMapper.toDtoRsp(booking));
        return bookingDtoRsp;
    }

    @Override
    @Transactional
    public BookingDtoRsp save(BookingDtoRq bookingDtoRq) {
        ClientDto client = bookingDtoRq.getClient();

        checkClient(client, bookingDtoRq);
        checkDates(bookingDtoRq);

        BigDecimal totalPrice = calculateTotalPrice(bookingDtoRq);
        Booking entity = bookingMapper.toEntity(bookingDtoRq, totalPrice);
        Booking savedEntity = bookingRepository.save(entity);
        BookingDtoRsp dtoRsp = bookingMapper.toDtoRsp(savedEntity);
        return dtoRsp;
    }

        private void checkDates(BookingDtoRq bookingDtoRq) {
        Integer advertId = bookingDtoRq.getAdvertId();
        LocalDate startRequestDate = bookingDtoRq.getStartDate();
        LocalDate endRequestDate = bookingDtoRq.getEndDate();
//        Получаем объявление из БД
        Advert advert = advertRepository.findById(advertId)
                .orElseThrow(() -> new AdvertNotFoundException(advertId));
//        Получаем список Bookings из advert
        List<Booking> bookings = advert.getBookings();
//      Получаем количество пересечений
        long countIntersections = bookings.stream()
                .filter(booking -> checkIntersections(booking.getStartDate(), booking.getEndDate(),
                        startRequestDate, endRequestDate))
                .count();

        if (countIntersections > 0) {
            throw new DateRangeIntersectionException(startRequestDate, endRequestDate);
        }

    }

    private boolean checkIntersections(LocalDate startDateAdvert, LocalDate endDateAdvert,
                                    LocalDate startRequestDate, LocalDate endRequestDate) {
        return !startDateAdvert.isAfter(endRequestDate) && !startRequestDate.isAfter(endDateAdvert);
    }

    private void checkClient(ClientDto clientDto, BookingDtoRq bookingDtoRq) {
        Integer clientId = clientDto.getId();

        if (clientId != null) {
            bookingDtoRq.setClient(clientMapper.toDto(clientRepository.findById(clientId)
                    .orElseThrow(() -> new ClientNotFoundException(clientId))));
        } else {
            bookingDtoRq.setClient(clientMapper.toDto(clientRepository.save(clientMapper.toEntity(clientDto))));
//            clientRepository.save(clientMapper.toEntity(clientDto));
        }
    }

    private BigDecimal calculateTotalPrice(BookingDtoRq dtoRq) {
        BigDecimal priceOfDay = advertRepository.findById(dtoRq.getAdvertId()).orElseThrow().getPrice();
        int countDays = Period.between(dtoRq.getStartDate(), dtoRq.getEndDate()).getDays();
        return priceOfDay.multiply(BigDecimal.valueOf(countDays));
    }
}
