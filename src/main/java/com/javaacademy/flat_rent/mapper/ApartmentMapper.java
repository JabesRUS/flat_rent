package com.javaacademy.flat_rent.mapper;

import com.javaacademy.flat_rent.dto.ApartmentDto;
import com.javaacademy.flat_rent.entity.Apartment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public abstract class ApartmentMapper {

    @Mapping(target = "adverts", ignore = true)
    public abstract Apartment toEntity(ApartmentDto dto);

    public abstract ApartmentDto toDto(Apartment entity);
}
