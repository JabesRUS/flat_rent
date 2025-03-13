package com.javaacademy.flat_rent.service.api;

import com.javaacademy.flat_rent.dto.BookingDtoRq;
import com.javaacademy.flat_rent.dto.BookingDtoRsp;
import org.springframework.stereotype.Service;

@Service
public interface BookingService {

    BookingDtoRsp save(BookingDtoRq bookingDtoRq);

}
