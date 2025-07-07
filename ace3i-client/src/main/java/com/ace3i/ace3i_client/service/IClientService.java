package com.ace3i.ace3i_client.service;

import com.ace3i.ace3i_client.model.Client;

import java.util.List;

public interface IClientService {
    Client create(Client client);
    Client update(String codeClient, Client client);
    void delete(String codeClient);
    List<Client> getAll();
    Client getById(String codeClient);
}
