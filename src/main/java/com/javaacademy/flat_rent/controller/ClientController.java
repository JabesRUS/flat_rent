package com.javaacademy.flat_rent.controller;

import com.javaacademy.flat_rent.service.api.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
@RequiredArgsConstructor
public class ClientController {
    private final ClientService clientService;

    @DeleteMapping("/{id}")
    public boolean deleteClientById(@PathVariable Integer id) {
        return clientService.deleteById(id);
    }
}
