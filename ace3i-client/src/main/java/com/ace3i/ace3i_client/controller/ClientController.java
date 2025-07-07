package com.ace3i.ace3i_client.controller;

import com.ace3i.ace3i_client.model.Client;
import com.ace3i.ace3i_client.service.IClientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
@RequiredArgsConstructor
public class ClientController {

    private final IClientService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Client create(@Valid @RequestBody Client client) {
        return service.create(client);
    }

    @PutMapping("/{codeClient}")
    public Client update(@PathVariable String codeClient, @Valid @RequestBody Client client) {
        return service.update(codeClient, client);
    }

    @DeleteMapping("/{codeClient}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String codeClient) {
        service.delete(codeClient);
    }

    @GetMapping
    public List<Client> getAll() {
        return service.getAll();
    }

    @GetMapping("/{codeClient}")
    public Client getById(@PathVariable String codeClient) {
        return service.getById(codeClient);
    }
}
