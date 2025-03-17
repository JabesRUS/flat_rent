package com.javaacademy.flat_rent.service.api;

import com.javaacademy.flat_rent.dto.AdvertDtoRq;
import com.javaacademy.flat_rent.dto.AdvertDtoRsp;
import org.springframework.stereotype.Service;

@Service
public interface AdvertService {

    AdvertDtoRsp save(AdvertDtoRq advertDtoRq);

}
