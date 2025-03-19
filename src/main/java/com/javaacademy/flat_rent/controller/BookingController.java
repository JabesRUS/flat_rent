package com.javaacademy.flat_rent.controller;

import com.javaacademy.flat_rent.dto.BookingDtoRq;
import com.javaacademy.flat_rent.dto.BookingDtoRsp;
import com.javaacademy.flat_rent.service.api.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/booking")
@RequiredArgsConstructor
public class BookingController {
    private final BookingService bookingService;

    @PostMapping
    public ResponseEntity<?> bookingApartment(@RequestBody BookingDtoRq bookingDtoRq) {
        BookingDtoRsp bookingDtoRsp = bookingService.save(bookingDtoRq);
        return ResponseEntity.status(HttpStatus.OK)
                .body(bookingDtoRsp);
    }
}
