package com.javaacademy.flat_rent.service.api;

import com.javaacademy.flat_rent.dto.BookingDtoRq;
import com.javaacademy.flat_rent.dto.BookingDtoRsp;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public interface BookingService {

    BookingDtoRsp save(BookingDtoRq bookingDtoRq);

    Page<BookingDtoRsp> getBookingsByEmail(String email, Integer page, Integer size);
}
