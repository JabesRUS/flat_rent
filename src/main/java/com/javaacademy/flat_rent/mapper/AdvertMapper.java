package com.javaacademy.flat_rent.mapper;

import com.javaacademy.flat_rent.dto.AdvertDtoRq;
import com.javaacademy.flat_rent.dto.AdvertDtoRsp;
import com.javaacademy.flat_rent.entity.Advert;
import com.javaacademy.flat_rent.entity.Apartment;
import com.javaacademy.flat_rent.exception.ApartmentNotFoundException;
import com.javaacademy.flat_rent.repository.ApartmentRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
uses = ApartmentMapper.class)
public abstract class AdvertMapper {
    @Autowired
    private ApartmentRepository apartmentRepository;

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "bookings", ignore = true)
    @Mapping(target = "apartment", source = "apartmentId", qualifiedByName = "getApartmentById")
    public abstract Advert toEntityWithRelation(AdvertDtoRq dto);

    @Named("getApartmentById")
    protected Apartment getApartmentById(Integer apartmentId) {
        if (apartmentId == null) {
            return null;
        }
        return apartmentRepository.findById(apartmentId)
                .orElseThrow(() -> new ApartmentNotFoundException(apartmentId));
    }

    public abstract AdvertDtoRsp toDto(Advert entity);

}
