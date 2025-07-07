package com.ace3i.ace3i_paiement.service;

import com.ace3i.ace3i_paiement.model.Paiement;

import java.util.List;

public interface IPaiementService {

    Paiement create(Paiement paiement);

    Paiement update(Long id, Paiement updated);

    void delete(Long id);

    List<Paiement> getAll();

    Paiement getById(Long id);

    List<Paiement> getByCodeClient(String codeClient);

    List<Paiement> getByNumeroFacture(String numeroFacture);
}