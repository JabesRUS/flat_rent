package com.javaacademy.flat_rent.service.api;

import com.javaacademy.flat_rent.dto.ClientDto;
import org.springframework.stereotype.Service;

@Service
public interface ClientService {
    ClientDto save(ClientDto clientDto);

}
