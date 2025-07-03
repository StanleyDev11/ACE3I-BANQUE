package com.ace3i.ace3i_client.repository;

import com.ace3i.ace3i_client.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, String> {
    boolean existsByNumeroCompte(String numeroCompte);

    // Vérifie si un numéro de compte existe pour un client différent (utile pour update)
    boolean existsByNumeroCompteAndCodeClientNot(String numeroCompte, String codeClient);
}
