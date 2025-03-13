package com.javaacademy.flat_rent.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class BookingDtoRq {

    private Integer id;

    @NonNull
    @JsonProperty("date_start")
    private LocalDate startDate;

    @NonNull
    @JsonProperty("date_finish")
    private LocalDate endDate;

    @NonNull
    @JsonProperty("client_id")
    private Integer clientId;

    @NonNull
    @JsonProperty("advert_id")
    private Integer advertId;
}
