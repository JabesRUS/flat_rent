package com.javaacademy.flat_rent.service.api;

import com.javaacademy.flat_rent.dto.AdvertDtoRq;
import com.javaacademy.flat_rent.dto.AdvertDtoRsp;
import com.javaacademy.flat_rent.entity.Advert;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AdvertService {

    AdvertDtoRsp save(AdvertDtoRq advertDtoRq);

    Page<AdvertDtoRsp> getAdvertsByCity(String city, Integer page, Integer size);

}
