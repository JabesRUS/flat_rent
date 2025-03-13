package com.javaacademy.flat_rent.service.impl;

import com.javaacademy.flat_rent.dto.BookingDtoRq;
import com.javaacademy.flat_rent.dto.BookingDtoRsp;
import com.javaacademy.flat_rent.mapper.BookingMapper;
import com.javaacademy.flat_rent.repository.AdvertRepository;
import com.javaacademy.flat_rent.repository.BookingRepository;
import com.javaacademy.flat_rent.service.api.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Period;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {
    private final BookingMapper bookingMapper;
    private final BookingRepository bookingRepository;
    private final AdvertRepository advertRepository;

    @Override
    public BookingDtoRsp save(BookingDtoRq bookingDtoRq) {
        BigDecimal totalPrice = calculateTotalPrice(bookingDtoRq);
        return bookingMapper.toDtoRsp(bookingRepository.save(bookingMapper.toEntity(bookingDtoRq, totalPrice)));
    }


    private BigDecimal calculateTotalPrice(BookingDtoRq dtoRq) {
        BigDecimal priceOfDay = advertRepository.findById(dtoRq.getAdvertId()).orElseThrow().getPrice();
        int countDays = Period.between(dtoRq.getStartDate(), dtoRq.getEndDate()).getDays();
        return priceOfDay.multiply(BigDecimal.valueOf(countDays));
    }
}
