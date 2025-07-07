package com.ace3i.ace3i_facture.controller;

import com.ace3i.ace3i_facture.model.Facture;
import com.ace3i.ace3i_facture.service.IFactureService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/factures")
@RequiredArgsConstructor
public class FactureController {

    private final IFactureService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Facture create(@Valid @RequestBody Facture facture) {
        return service.create(facture);
    }

    @PutMapping("/{reference}")
    public Facture update(@PathVariable String reference, @Valid @RequestBody Facture facture) {
        return service.update(reference, facture);
    }

    @DeleteMapping("/{reference}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String reference) {
        service.delete(reference);
    }

    @GetMapping
    public List<Facture> getAll() {
        return service.getAll();
    }

    @GetMapping("/{reference}")
    public Facture getById(@PathVariable String reference) {
        return service.getById(reference);
    }
}
