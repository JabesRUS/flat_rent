package com.javaacademy.flat_rent.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
public class ClientDto {
    private Integer id;

    @NonNull
    private String name;

    @NonNull
    private String email;
}
