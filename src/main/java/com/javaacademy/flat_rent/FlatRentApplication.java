package com.javaacademy.flat_rent;

import com.javaacademy.flat_rent.entity.Booking;
import com.javaacademy.flat_rent.repository.AdvertRepository;
import com.javaacademy.flat_rent.repository.ApartmentRepository;
import com.javaacademy.flat_rent.repository.BookingRepository;
import com.javaacademy.flat_rent.repository.ClientRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.math.BigDecimal;
import java.time.LocalDate;

@SpringBootApplication
public class FlatRentApplication {

    private static final int DAYS_TO_ADD = 7;

    public static void main(String[] args) {SpringApplication.run(FlatRentApplication.class, args);
    }
}
