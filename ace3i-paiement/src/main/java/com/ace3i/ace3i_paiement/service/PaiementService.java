package com.ace3i.ace3i_paiement.service;

import com.ace3i.ace3i_paiement.PaiementNotFoundException;
import com.ace3i.ace3i_paiement.model.Paiement;
import com.ace3i.ace3i_paiement.repository.PaiementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import jakarta.validation.ValidationException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PaiementService {

    private final PaiementRepository repository;

    // Exemple avec RestTemplate (tu peux aussi injecter les vrais repos client/facture si dispo localement)
    private final RestTemplate restTemplate = new RestTemplate();
    private static final String CLIENT_API_URL = "http://localhost:8080/api/clients/";
    private static final String FACTURE_API_URL = "http://localhost:8080/api/factures/";

    public Paiement create(Paiement paiement) {
        if (!clientExiste(paiement.getCodeClient())) {
            throw new ValidationException("Le client n'existe pas.");
        }

        if (!factureExiste(paiement.getNumeroFacture())) {
            throw new ValidationException("La facture n'existe pas.");
        }

        return repository.save(paiement);
    }

    public Paiement update(Long id, Paiement updated) {
        Paiement paiement = repository.findById(id)
                .orElseThrow(() -> new PaiementNotFoundException("Paiement introuvable"));

        paiement.setDatePaiement(updated.getDatePaiement());
        paiement.setMontant(updated.getMontant());
        paiement.setCodeClient(updated.getCodeClient());
        paiement.setNumeroFacture(updated.getNumeroFacture());
        paiement.setModePaiement(updated.getModePaiement());

        return repository.save(paiement);
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new PaiementNotFoundException("Paiement introuvable");
        }
        repository.deleteById(id);
    }

    public List<Paiement> getAll() {
        return repository.findAll();
    }

    public Paiement getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new PaiementNotFoundException("Paiement introuvable"));
    }

    public List<Paiement> getByCodeClient(String codeClient) {
        return repository.findByCodeClient(codeClient);
    }

    public List<Paiement> getByNumeroFacture(String numeroFacture) {
        return repository.findByNumeroFacture(numeroFacture);
    }

    // Méthodes de vérification via REST
    private boolean clientExiste(String codeClient) {
        try {
            restTemplate.getForObject(CLIENT_API_URL + codeClient, Object.class);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private boolean factureExiste(String numeroFacture) {
        try {
            restTemplate.getForObject(FACTURE_API_URL + numeroFacture, Object.class);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
