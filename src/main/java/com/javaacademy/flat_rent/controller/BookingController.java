package com.javaacademy.flat_rent.controller;

import com.javaacademy.flat_rent.dto.BookingDtoRq;
import com.javaacademy.flat_rent.dto.BookingDtoRsp;
import com.javaacademy.flat_rent.service.api.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/booking")
@RequiredArgsConstructor
public class BookingController {
    private final BookingService bookingService;

    @PostMapping
    public ResponseEntity<BookingDtoRsp> bookingApartment(@RequestBody BookingDtoRq bookingDtoRq) {
        BookingDtoRsp bookingDtoRsp = bookingService.save(bookingDtoRq);
        return ResponseEntity.status(HttpStatus.OK)
                .body(bookingDtoRsp);
    }

    @GetMapping
    public ResponseEntity<Page<BookingDtoRsp>> getBookingsByEmail(@RequestParam String email,
                                                                  @RequestParam(required = false) Integer page,
                                                                  @RequestParam(required = false) Integer size) {
        Page<BookingDtoRsp> bookingsByEmail = bookingService.getBookingsByEmail(email, page, size);

        return ResponseEntity.status(HttpStatus.OK).body(bookingsByEmail);
    }
}
