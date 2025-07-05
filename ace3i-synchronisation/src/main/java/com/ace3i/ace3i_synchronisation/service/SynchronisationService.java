package com.ace3i.ace3i_synchronisation.service;

import com.ace3i.ace3i_synchronisation.model.Paiement; // à créer ou à importer via REST
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;

@Service
public class SynchronisationService {

    @Resource(name = "oracleDataSource")
    private DataSource oracleDataSource;

    public void synchroniserPaiement(Paiement paiement) {
        try (Connection conn = oracleDataSource.getConnection()) {
            CallableStatement stmt = conn.prepareCall("{ call sync_paiement(?, ?, ?, ?, ?) }");
            stmt.setString(1, paiement.getCodeClient());
            stmt.setDouble(2, paiement.getMontant());
            stmt.setString(3, paiement.getNumeroFacture());
            stmt.setDate(4, Date.valueOf(paiement.getDatePaiement()));
            stmt.setString(5, paiement.getModePaiement().name());

            stmt.execute();
        } catch (Exception e) {
            e.printStackTrace(); // ou mieux: log.error("Erreur de synchronisation", e);
        }
    }
}
