package com.javaacademy.flat_rent.service.impl;

import com.javaacademy.flat_rent.dto.BookingDtoRq;
import com.javaacademy.flat_rent.dto.BookingDtoRsp;
import com.javaacademy.flat_rent.dto.ClientDto;
import com.javaacademy.flat_rent.entity.Client;
import com.javaacademy.flat_rent.exception.ClientNotFoundException;
import com.javaacademy.flat_rent.mapper.BookingMapper;
import com.javaacademy.flat_rent.mapper.ClientMapper;
import com.javaacademy.flat_rent.repository.AdvertRepository;
import com.javaacademy.flat_rent.repository.BookingRepository;
import com.javaacademy.flat_rent.repository.ClientRepository;
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
    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;


    @Override
    public BookingDtoRsp save(BookingDtoRq bookingDtoRq) {
        ClientDto client = bookingDtoRq.getClient();
        checkClient(client);

        BigDecimal totalPrice = calculateTotalPrice(bookingDtoRq);

        return bookingMapper.toDtoRsp(bookingRepository.save(bookingMapper.toEntity(bookingDtoRq, totalPrice)));
    }

    private void checkClient(ClientDto clientDto) {
        Integer clientId = clientDto.getId();

        if (clientId != null) {
            clientRepository.findById(clientId)
                    .orElseThrow(() -> new ClientNotFoundException(clientId));
        } else {
            clientRepository.save(clientMapper.toEntity(clientDto));
        }
    }

    private BigDecimal calculateTotalPrice(BookingDtoRq dtoRq) {
        BigDecimal priceOfDay = advertRepository.findById(dtoRq.getAdvertId()).orElseThrow().getPrice();
        int countDays = Period.between(dtoRq.getStartDate(), dtoRq.getEndDate()).getDays();
        return priceOfDay.multiply(BigDecimal.valueOf(countDays));
    }
}
