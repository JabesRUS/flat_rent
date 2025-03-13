package com.javaacademy.flat_rent.mapper;

import com.javaacademy.flat_rent.dto.AdvertDtoRq;
import com.javaacademy.flat_rent.dto.AdvertDtoRsp;
import com.javaacademy.flat_rent.entity.Advert;
import com.javaacademy.flat_rent.repository.ApartmentRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
uses = ApartmentMapper.class)
public abstract class AdvertMapper {
    @Autowired
    private ApartmentRepository apartmentRepository;

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "bookings", ignore = true)
    public abstract Advert toEntityWithRelation(AdvertDtoRq dto);

    public abstract AdvertDtoRsp toDto(Advert entity);

}
