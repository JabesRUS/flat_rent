package com.javaacademy.flat_rent.repository;

import com.javaacademy.flat_rent.entity.Advert;
import com.javaacademy.flat_rent.entity.Booking;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Integer> {

//    Page<Advert> findByApartmentCityOrderByPriceDesc(String city, Pageable pageable);
    Page<Booking> findByClientEmail(String email, Pageable pageable);
}
