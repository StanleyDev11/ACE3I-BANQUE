package com.ace3i.ace3i_synchronisation.service;

import com.ace3i.ace3i_synchronisation.model.Paiement;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;

@Service
public class SynchronisationService {

    private static final Logger log = LoggerFactory.getLogger(SynchronisationService.class);

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

            log.info(" Paiement synchronisé : facture {}, client {}", paiement.getNumeroFacture(), paiement.getCodeClient());

        } catch (Exception e) {
            log.error(" Erreur de synchronisation du paiement : facture {}, client {}",
                    paiement.getNumeroFacture(), paiement.getCodeClient(), e);
        }
    }
}
