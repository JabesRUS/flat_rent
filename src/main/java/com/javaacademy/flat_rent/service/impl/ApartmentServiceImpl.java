package com.javaacademy.flat_rent.service.impl;

import com.javaacademy.flat_rent.dto.ApartmentDto;
import com.javaacademy.flat_rent.entity.Apartment;
import com.javaacademy.flat_rent.mapper.ApartmentMapper;
import com.javaacademy.flat_rent.repository.ApartmentRepository;
import com.javaacademy.flat_rent.service.api.AdvertService;
import com.javaacademy.flat_rent.service.api.ApartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ApartmentServiceImpl implements ApartmentService {
    private final ApartmentRepository apartmentRepository;
    private final ApartmentMapper apartmentMapper;

    @Override
    public ApartmentDto save(ApartmentDto apartmentDto) {
        Apartment entity = apartmentRepository.save(apartmentMapper.toEntity(apartmentDto));

        return apartmentMapper.toDto(entity);
    }

}
