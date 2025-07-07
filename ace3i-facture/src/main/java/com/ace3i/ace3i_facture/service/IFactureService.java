package com.ace3i.ace3i_facture.service;

import com.ace3i.ace3i_facture.model.Facture;

import java.util.List;

public interface IFactureService {
    Facture create(Facture facture);
    Facture update(String reference, Facture updated);
    void delete(String reference);
    List<Facture> getAll();
    Facture getById(String reference);
}
