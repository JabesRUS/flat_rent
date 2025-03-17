package com.javaacademy.flat_rent.controller;

import com.javaacademy.flat_rent.dto.AdvertDtoRq;
import com.javaacademy.flat_rent.dto.AdvertDtoRsp;
import com.javaacademy.flat_rent.service.api.AdvertService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/advert")
@RequiredArgsConstructor
public class advertController {
    private final AdvertService advertService;

    public AdvertDtoRsp create(@RequestBody AdvertDtoRq advertDtoRq) {
        return advertService.save(advertDtoRq);
    }
}
