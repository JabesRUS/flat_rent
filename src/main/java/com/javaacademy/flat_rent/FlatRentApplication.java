package com.javaacademy.flat_rent;

import com.javaacademy.flat_rent.dto.BookingDtoRq;
import com.javaacademy.flat_rent.dto.BookingDtoRsp;
import com.javaacademy.flat_rent.service.api.AdvertService;
import com.javaacademy.flat_rent.service.api.ApartmentService;
import com.javaacademy.flat_rent.service.api.BookingService;
import com.javaacademy.flat_rent.service.api.ClientService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.time.LocalDate;


@SpringBootApplication
public class FlatRentApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(FlatRentApplication.class, args);

//        ApartmentService apartmentServiceImpl = context.getBean(ApartmentService.class);
//        ClientService clientServiceImpl = context.getBean(ClientService.class);
//        AdvertService advertServiceImpl = context.getBean(AdvertService.class);
//        BookingService bookingService = context.getBean(BookingService.class);

//        ApartmentDto apartmentDto = new ApartmentDto(null,
//                "СПБ",
//                "Ленина",
//                "12345",
//                "ONLY_ROOM");
//
//        apartmentService.save(apartmentDto);
//        System.out.println();

//        ClientDto clientDto = new ClientDto(null, "Семен", "qweqweqw@qweqwe.er");
//        ClientDto save = clientService.save(clientDto);
//        System.out.println(save);

//        AdvertDtoRq advertDtoRq = new AdvertDtoRq(null,
//                BigDecimal.valueOf(888), true, 2, "Гигантская квартира");
//        AdvertDtoRsp saveAdv = advertService.save(advertDtoRq);
//        System.out.println(saveAdv);

//        BookingDtoRq bookingDtoRq = new BookingDtoRq(null,
//                LocalDate.parse("2025-02-13"), LocalDate.parse("2025-02-17"), 1, 2);
//        BookingDtoRq bookingDtoRq = new BookingDtoRq();
//        bookingDtoRq.setId(null);
//        bookingDtoRq.setStartDate(LocalDate.parse("2025-02-13"));
//        bookingDtoRq.setEndDate(LocalDate.parse("2025-02-17"));
//        bookingDtoRq.setAdvertId(1);
//        bookingDtoRq.setClientId(2);
//
//        BookingDtoRsp bookingDtoRsp = bookingService.save(bookingDtoRq);
//        System.out.println(bookingDtoRsp);
    }
}
