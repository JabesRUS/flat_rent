package com.javaacademy.flat_rent.exception;

public class AdvertNotFoundException extends RuntimeException {
    public AdvertNotFoundException(Integer advertId) {
        super("Advert not found with id: " + advertId);
    }
}
