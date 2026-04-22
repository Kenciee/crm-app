package com.example.demo.service;

import com.example.demo.model.Client;
import com.example.demo.dto.ClientRequest;
import com.example.demo.dto.ClientResponse;
import com.example.demo.mapper.ClientMapper;
import java.util.ArrayList;
import java.util.List;
import java.util.*;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    private List<Client> clients = new ArrayList<>();
    private int idCounter = 1;

    public void addClient(ClientRequest request) {


        Client client = new Client(idCounter++, request.getName(), request.getEmail());
        clients.add(client);
    }

    public List<ClientResponse> getAllClients() {

        List<ClientResponse> result = new ArrayList<>();

        for (Client c : clients) {
            result.add(ClientMapper.toResponse(c));
        }

        return result;

    }

    private Client findEntityById(int id) {
        for (Client c : clients) {
            if (c.getId() == id) {
                return c;
            }
        }
        throw new RuntimeException("Клиент не найден");
    }
    public ClientResponse findById(int id) {
        Client c = findEntityById(id);
        return ClientMapper.toResponse(c);
    }
}

