package com.ace3i.ace3i_synchronisation;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.SQLException;

@Service
@RequiredArgsConstructor
public class SynchronisationService {

    private final DataSource oracleDataSource;

    @Scheduled(cron = "0 0 * * * *") // Toutes les heures
    public void synchroniserPaiements() {
        try (Connection connection = oracleDataSource.getConnection();
             CallableStatement stmt = connection.prepareCall("{ call PROCEDURE_SYNCHRO() }")) {

            stmt.execute();
            System.out.println("✅ Synchronisation Oracle réussie");

        } catch (SQLException e) {
            System.err.println("❌ Échec de la synchronisation : " + e.getMessage());
        }
    }
}
