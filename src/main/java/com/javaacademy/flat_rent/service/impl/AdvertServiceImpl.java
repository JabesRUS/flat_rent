package com.javaacademy.flat_rent.service.impl;

import com.javaacademy.flat_rent.dto.AdvertDtoRq;
import com.javaacademy.flat_rent.dto.AdvertDtoRsp;
import com.javaacademy.flat_rent.mapper.AdvertMapper;
import com.javaacademy.flat_rent.repository.AdvertRepository;
import com.javaacademy.flat_rent.service.api.AdvertService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdvertServiceImpl implements AdvertService {
    private final AdvertRepository advertRepository;
    private final AdvertMapper advertMapper;

    @Override
    public AdvertDtoRsp save(AdvertDtoRq advertDtoRq) {
        return advertMapper.toDto(advertRepository.save(advertMapper.toEntityWithRelation(advertDtoRq)));
    }
}
