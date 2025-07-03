package com.ace3i.ace3i_paiement.repository;

import com.ace3i.ace3i_paiement.model.Paiement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaiementRepository extends JpaRepository<Paiement, Long> {
}
