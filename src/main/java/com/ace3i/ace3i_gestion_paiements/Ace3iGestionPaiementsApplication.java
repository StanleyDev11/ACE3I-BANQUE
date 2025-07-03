package com.ace3i.ace3i_gestion_paiements;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication(scanBasePackages = {
		"com.ace3i.gestionpaiements",
		"com.ace3i.ace3i_client",
		"com.ace3i.ace3i_facture",
		"com.ace3i.ace3i_paiement"
})
public class Ace3iGestionPaiementsApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ace3iGestionPaiementsApplication.class, args);
	}

}
