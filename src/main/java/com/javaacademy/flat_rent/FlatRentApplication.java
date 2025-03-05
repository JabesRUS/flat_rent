package com.javaacademy.flat_rent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FlatRentApplication {

    private static final int DAYS_TO_ADD = 7;

    public static void main(String[] args) {
        SpringApplication.run(FlatRentApplication.class, args);
    }
}
