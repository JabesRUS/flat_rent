package com.javaacademy.flat_rent.exception;

public class ClientNotFoundException extends RuntimeException {
    public ClientNotFoundException(Integer clientId) {
        super("Client not found with id: " + clientId);
    }
}
