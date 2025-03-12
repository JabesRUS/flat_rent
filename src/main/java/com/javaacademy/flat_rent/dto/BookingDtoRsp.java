package com.javaacademy.flat_rent.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class BookingDtoRsp {

    private Integer id;

    @JsonProperty("date_start")
    private LocalDate startDate;

    @JsonProperty("date_finish")
    private LocalDate endDate;

    private ClientDto client;

    private AdvertDtoRsp advert;

    @JsonProperty("total_price")
    private BigDecimal totalPrice;
}
