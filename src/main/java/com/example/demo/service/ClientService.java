package com.example.demo.service;

import com.example.demo.model.Client;
import com.example.demo.dto.ClientRequest;
import com.example.demo.dto.ClientResponse;
import com.example.demo.mapper.ClientMapper;
import com.example.demo.repository.ClientRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClientService {
    private final ClientRepository repository;

    public ClientService(ClientRepository repository) {
        this.repository = repository;
    }

    public void addClient(ClientRequest request) {


        Client client = new Client(request.getName(), request.getEmail());
        repository.save(client);
    }

    public List<ClientResponse> getAllClients() {
        return repository.findAll()
                .stream()
                .map(ClientMapper::toResponse)
                .toList();

    }
    public ClientResponse findById(Long id) {
        Client client = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Клиент не найден"));
        return ClientMapper.toResponse(client);
    }
    public void delete(Long id) {
        repository.deleteById(id);
    }
}

