package com.ace3i.ace3i_synchronisation.job;

import com.ace3i.ace3i_synchronisation.model.Paiement;
import com.ace3i.ace3i_synchronisation.service.SynchronisationService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class PaiementSynchronisationJob {

    private final SynchronisationService synchronisationService;
    private final RestTemplate restTemplate = new RestTemplate();

    public PaiementSynchronisationJob(SynchronisationService synchronisationService) {
        this.synchronisationService = synchronisationService;
    }

    @Scheduled(fixedRate = 60000) // toutes les 60 secondes
    public void synchroniser() {
        // 🔁 Appel de ton API Paiement (PostgreSQL)
        List<Paiement> paiements = restTemplate.getForObject("http://localhost:8083/api/paiements", List.class);

        // 🔄 Synchroniser chaque paiement
        for (Paiement p : paiements) {
            synchronisationService.synchroniserPaiement(p);
        }
    }
}
