package com.javaacademy.flat_rent.mapper;

import com.javaacademy.flat_rent.dto.AdvertDtoRsp;
import com.javaacademy.flat_rent.dto.BookingDtoRq;
import com.javaacademy.flat_rent.dto.BookingDtoRsp;
import com.javaacademy.flat_rent.dto.ClientDto;
import com.javaacademy.flat_rent.entity.Advert;
import com.javaacademy.flat_rent.entity.Booking;
import com.javaacademy.flat_rent.entity.Client;
import com.javaacademy.flat_rent.repository.AdvertRepository;
import com.javaacademy.flat_rent.repository.ClientRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public abstract class BookingMapper {
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ClientMapper clientMapper;
    @Autowired
    private AdvertMapper advertMapper;
    @Autowired
    private AdvertRepository advertRepository;

    @Mapping(target = "client", source = "dtoRq.clientId", qualifiedByName = "getClient")
    @Mapping(target = "advert", source = "dtoRq.advertId", qualifiedByName = "getAdvert")
    @Mapping(target = "totalPrice", source = "totalPrice")
    public abstract Booking toEntity(BookingDtoRq dtoRq, BigDecimal totalPrice);

    @Named("getClient")
    protected Client getClient(Integer clientId) {
        return clientRepository.findById(clientId).orElseThrow();
    }

    @Named("getAdvert")
    protected Advert getAdvert(Integer advertId) {
        return advertRepository.findById(advertId).orElseThrow();
    }

    @Mapping(target = "client", source = "client", qualifiedByName = "getClientDto")
    @Mapping(target = "advert", source = "advert", qualifiedByName = "getAdvertDtoRsp")
    public abstract BookingDtoRsp toDtoRsp(Booking entity);

    @Named("getClientDto")
    protected ClientDto getClientDto(Client client) {
        return clientMapper.toDto(client);
    }

    @Named("getAdvertDtoRsp")
    protected AdvertDtoRsp getAdvertDtoRsp(Advert advert) {
        return advertMapper.toDtoRsp(advert);
    }
}
