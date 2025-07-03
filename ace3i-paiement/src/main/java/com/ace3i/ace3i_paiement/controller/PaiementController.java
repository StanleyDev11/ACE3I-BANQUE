package com.ace3i.ace3i_paiement.controller;

import com.ace3i.ace3i_paiement.model.Paiement;
import com.ace3i.ace3i_paiement.service.PaiementService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/paiements")
@RequiredArgsConstructor
public class PaiementController {

    private final PaiementService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Paiement create(@Valid @RequestBody Paiement paiement) {
        return service.create(paiement);
    }

    @PutMapping("/{id}")
    public Paiement update(@PathVariable Long id, @Valid @RequestBody Paiement paiement) {
        return service.update(id, paiement);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping
    public List<Paiement> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Paiement getById(@PathVariable Long id) {
        return service.getById(id);
    }
}
