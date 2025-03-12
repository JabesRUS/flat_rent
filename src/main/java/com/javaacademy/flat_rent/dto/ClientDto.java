package com.javaacademy.flat_rent.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ClientDto {
    private Integer id;
    private String name;
    private String email;
}
