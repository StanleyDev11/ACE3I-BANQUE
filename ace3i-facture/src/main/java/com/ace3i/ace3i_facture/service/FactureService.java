package com.ace3i.ace3i_facture.service;

import com.ace3i.ace3i_facture.FactureNotFoundException;
import com.ace3i.ace3i_facture.model.Facture;
import com.ace3i.ace3i_facture.repository.FactureRepository;
import jakarta.validation.ValidationException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FactureService {

    private final FactureRepository repository;

    public Facture create(Facture facture) {
        if (repository.existsByReference(facture.getReference())) {
            throw new ValidationException("La référence de la facture existe déjà.");
        }
        return repository.save(facture);
    }

    public Facture update(String reference, Facture updated) {
        Facture facture = repository.findById(reference)
                .orElseThrow(() -> new FactureNotFoundException("Facture introuvable"));

        facture.setDescription(updated.getDescription());
        facture.setMontant(updated.getMontant());
        facture.setFacturier(updated.getFacturier());

        return repository.save(facture);
    }

    public void delete(String reference) {
        if (!repository.existsById(reference)) {
            throw new FactureNotFoundException("Facture introuvable");
        }
        repository.deleteById(reference);
    }

    public List<Facture> getAll() {
        return repository.findAll();
    }

    public Facture getById(String reference) {
        return repository.findById(reference)
                .orElseThrow(() -> new FactureNotFoundException("Facture introuvable"));
    }
}
