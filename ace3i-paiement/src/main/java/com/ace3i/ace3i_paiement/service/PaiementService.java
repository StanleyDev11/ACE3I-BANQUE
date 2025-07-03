package com.ace3i.ace3i_paiement.service;

import com.ace3i.ace3i_paiement.model.Paiement;
import com.ace3i.ace3i_paiement.repository.PaiementRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaiementService {

    private final PaiementRepository repository;

    public Paiement create(Paiement paiement) {
        return repository.save(paiement);
    }

    public Paiement update(Long id, Paiement updated) {
        Paiement paiement = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Paiement introuvable"));
        paiement.setDatePaiement(updated.getDatePaiement());
        paiement.setMontant(updated.getMontant());
        paiement.setCodeClient(updated.getCodeClient());
        paiement.setNumeroFacture(updated.getNumeroFacture());
        paiement.setModePaiement(updated.getModePaiement());

        return repository.save(paiement);
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Paiement introuvable");
        }
        repository.deleteById(id);
    }

    public List<Paiement> getAll() {
        return repository.findAll();
    }

    public Paiement getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Paiement introuvable"));
    }
}
