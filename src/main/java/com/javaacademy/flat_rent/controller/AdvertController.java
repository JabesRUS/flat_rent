package com.javaacademy.flat_rent.controller;

import com.javaacademy.flat_rent.dto.AdvertDtoRq;
import com.javaacademy.flat_rent.dto.AdvertDtoRsp;
import com.javaacademy.flat_rent.service.api.AdvertService;
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

import java.util.List;

@RestController
@RequestMapping("/advert")
@RequiredArgsConstructor
public class AdvertController {
    private final AdvertService advertService;

    @PostMapping
    public ResponseEntity<AdvertDtoRsp> createOrUpdateAdvert(@RequestBody AdvertDtoRq advertDtoRq) {
        AdvertDtoRsp advertDtoRsp = advertService.save(advertDtoRq);

        return ResponseEntity.status(HttpStatus.CREATED).
                body(advertDtoRsp);
    }

    @GetMapping()
    public ResponseEntity<Page<AdvertDtoRsp>> getAdvertByCity(@RequestParam String city,
                                                              @RequestParam(required = false) Integer page,
                                                              @RequestParam(required = false) Integer size) {
        Page<AdvertDtoRsp> adverts = advertService.getAdvertsByCity(city, page, size);

        return ResponseEntity.status(HttpStatus.OK)
                .body(adverts);
    }
}
