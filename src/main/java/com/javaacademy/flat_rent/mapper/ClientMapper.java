package com.javaacademy.flat_rent.mapper;

import com.javaacademy.flat_rent.dto.ClientDto;
import com.javaacademy.flat_rent.entity.Client;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public abstract class ClientMapper {

    public abstract Client toEntity(ClientDto dto);

    public  abstract ClientDto toDto(Client entity);
}
