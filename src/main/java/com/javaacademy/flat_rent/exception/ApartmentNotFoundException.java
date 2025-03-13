package com.javaacademy.flat_rent.exception;

public class ApartmentNotFoundException extends RuntimeException {
    public ApartmentNotFoundException(Integer apartmentId) {
        super("Apartment not found with id: " + apartmentId);
    }
}
