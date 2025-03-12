package com.javaacademy.flat_rent.mapper;

import com.javaacademy.flat_rent.dto.AdvertDtoRq;
import com.javaacademy.flat_rent.dto.AdvertDtoRsp;
import com.javaacademy.flat_rent.dto.ApartmentDto;
import com.javaacademy.flat_rent.entity.Advert;
import com.javaacademy.flat_rent.entity.Apartment;
import com.javaacademy.flat_rent.repository.ApartmentRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public abstract class AdvertMapper {
    @Autowired
    private ApartmentRepository apartmentRepository;
    @Autowired
    private ApartmentMapper apartmentMapper;

    @Mapping(target = "apartment", source = "apartmentId", qualifiedByName = "getApartment")
    @Mapping(target = "bookings", ignore = true)
    public abstract Advert toEntity(AdvertDtoRq dto);

    @Named("getApartment")
    protected Apartment getApartment(Integer apartmentId) {
        return apartmentRepository.findById(apartmentId).orElseThrow();
    }

    @Mapping(target = "apartmentId", source = "apartment", qualifiedByName = "getApartmentId")
    public abstract AdvertDtoRq toDto(Advert entity);

    @Named("getApartmentId")
    protected Integer getApartmentId(Apartment apartment) {
        return apartment.getId();
    }

    @Mapping(target = "apartment", source = "apartment", qualifiedByName = "getApartmentDto")
    public abstract AdvertDtoRsp toDtoRsp(Advert entity);

    @Named("getApartmentDto")
    protected ApartmentDto getApartmentDto(Apartment apartment) {
        return apartmentMapper.toDto(apartment);
    }
}
