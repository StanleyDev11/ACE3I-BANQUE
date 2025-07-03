package com.ace3i.ace3i_paiement.repository;

import com.ace3i.ace3i_paiement.model.Paiement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaiementRepository extends JpaRepository<Paiement, Long> {

    // Trouver les paiements d’un client donné
    List<Paiement> findByCodeClient(String codeClient);

    // Trouver les paiements liés à une facture donnée
    List<Paiement> findByNumeroFacture(String numeroFacture);
}
