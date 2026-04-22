package com.example.demo.controller;

import com.example.demo.dto.ClientRequest;
import com.example.demo.dto.ClientResponse;
import com.example.demo.service.ClientService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {
    private final ClientService service;

    public ClientController(ClientService service) {
        this.service = service;
    }
    @PostMapping
    public String addClient(@RequestBody ClientRequest request) {
        service.addClient(request);
        return "Клиент добавлен";
    }

    @GetMapping
    public List<ClientResponse> getAll() {
        return service.getAllClients();
    }

    @GetMapping("/{id}")
    public ClientResponse getById(@PathVariable Long id) {
        return service.findById(id);
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "Удалено";
    }
}
