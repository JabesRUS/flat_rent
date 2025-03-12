package com.javaacademy.flat_rent.service;

import com.javaacademy.flat_rent.dto.ApartmentDto;
import com.javaacademy.flat_rent.entity.Apartment;
import com.javaacademy.flat_rent.mapper.ApartmentMapper;
import com.javaacademy.flat_rent.repository.ApartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ApartmentService {
    private final ApartmentRepository apartmentRepository;
    private final ApartmentMapper apartmentMapper;

    public ApartmentDto save(ApartmentDto apartmentDto) {
        Apartment entity = apartmentRepository.save(apartmentMapper.toEntity(apartmentDto));

        return apartmentMapper.toDto(entity);
    }

}
