package com.example.demo.mapper;

import com.example.demo.dto.ClientResponse;
import com.example.demo.model.Client;

public class ClientMapper {

    public static ClientResponse toResponse(Client client) {
        return new ClientResponse(
                client.getId(),
                client.getName(),
                client.getEmail()
        );
    }
}