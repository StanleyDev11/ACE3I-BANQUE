package com.ace3i.ace3i_client.repository;

import com.ace3i.ace3i_client.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, String> {
    boolean existsByNumeroCompte(String numeroCompte);
}
