package com.javaacademy.flat_rent.service;

import com.javaacademy.flat_rent.dto.ClientDto;
import com.javaacademy.flat_rent.mapper.ClientMapper;
import com.javaacademy.flat_rent.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    public ClientDto save(ClientDto clientDto) {
        return clientMapper.toDto(clientRepository.save(clientMapper.toEntity(clientDto)));
    }

}
