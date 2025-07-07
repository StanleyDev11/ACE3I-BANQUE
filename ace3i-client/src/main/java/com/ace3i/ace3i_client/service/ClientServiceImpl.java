package com.ace3i.ace3i_client.service;

import com.ace3i.ace3i_client.ClientNotFoundException;
import com.ace3i.ace3i_client.model.Client;
import com.ace3i.ace3i_client.repository.ClientRepository;
import jakarta.validation.ValidationException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements IClientService {

    private final ClientRepository repository;

    @Override
    public Client create(Client client) {
        if (repository.existsById(client.getCodeClient())) {
            throw new ValidationException("Le code client existe déjà.");
        }
        if (repository.existsByNumeroCompte(client.getNumeroCompte())) {
            throw new ValidationException("Le numéro de compte existe déjà.");
        }
        return repository.save(client);
    }

    @Override
    public Client update(String codeClient, Client updated) {
        Client client = repository.findById(codeClient)
                .orElseThrow(() -> new ClientNotFoundException("Client introuvable"));

        if (repository.existsByNumeroCompteAndCodeClientNot(updated.getNumeroCompte(), codeClient)) {
            throw new IllegalArgumentException("Le numéro de compte est déjà utilisé par un autre client.");
        }

        client.setNom(updated.getNom());
        client.setPrenom(updated.getPrenom());
        client.setNumeroCompte(updated.getNumeroCompte());
        client.setSolde(updated.getSolde());

        return repository.save(client);
    }

    @Override
    public void delete(String codeClient) {
        if (!repository.existsById(codeClient)) {
            throw new ClientNotFoundException("Client introuvable");
        }
        repository.deleteById(codeClient);
    }

    @Override
    public List<Client> getAll() {
        return repository.findAll();
    }

    @Override
    public Client getById(String codeClient) {
        return repository.findById(codeClient)
                .orElseThrow(() -> new ClientNotFoundException("Client introuvable"));
    }
}
