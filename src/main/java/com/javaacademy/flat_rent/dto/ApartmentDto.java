package com.javaacademy.flat_rent.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApartmentDto {

    private Integer id;
    private String city;
    private String street;
    @JsonProperty("house")
    private String houseNumber;
    @JsonProperty("apartment_type")
    private String apartmentType;
}
