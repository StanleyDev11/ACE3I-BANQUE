package com.ace3i.ace3i_facture.repository;

import com.ace3i.ace3i_facture.model.Facture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FactureRepository extends JpaRepository<Facture, String> {

    boolean existsByReference(String reference);
}
