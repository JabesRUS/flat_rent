package com.javaacademy.flat_rent.service;

import com.javaacademy.flat_rent.dto.AdvertDtoRq;
import com.javaacademy.flat_rent.dto.AdvertDtoRsp;
import com.javaacademy.flat_rent.mapper.AdvertMapper;
import com.javaacademy.flat_rent.repository.AdvertRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdvertService {
    private final AdvertRepository advertRepository;
    private final AdvertMapper advertMapper;

    public AdvertDtoRsp save(AdvertDtoRq advertDtoRq) {
        return advertMapper.toDtoRsp(advertRepository.save(advertMapper.toEntity(advertDtoRq)));
    }
}
