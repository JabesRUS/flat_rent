package com.javaacademy.flat_rent.service.api;

import com.javaacademy.flat_rent.dto.ApartmentDto;
import org.springframework.stereotype.Service;

@Service
public interface ApartmentService {
    ApartmentDto save(ApartmentDto apartmentDto);

}
