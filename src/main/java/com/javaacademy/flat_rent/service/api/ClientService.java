package com.javaacademy.flat_rent.service.api;

import com.javaacademy.flat_rent.dto.ClientDto;
import com.javaacademy.flat_rent.mapper.ClientMapper;
import com.javaacademy.flat_rent.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public interface ClientService {
    ClientDto save(ClientDto clientDto);

}
