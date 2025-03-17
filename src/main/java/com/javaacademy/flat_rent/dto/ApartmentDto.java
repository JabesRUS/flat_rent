package com.javaacademy.flat_rent.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.javaacademy.flat_rent.entity.ApartmentType;
import lombok.Data;
import lombok.NonNull;

@Data
public class ApartmentDto {

    private Integer id;

    @NonNull
    private String city;

    @NonNull
    private String street;

    @NonNull
    private String house;

    @NonNull
    @JsonProperty("apartment_type")
    private ApartmentType apartmentType;
}
