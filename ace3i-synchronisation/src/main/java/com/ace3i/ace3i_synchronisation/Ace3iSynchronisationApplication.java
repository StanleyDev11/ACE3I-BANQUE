package com.ace3i.ace3i_synchronisation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling // Active les tâches planifiées comme @Scheduled
public class Ace3iSynchronisationApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ace3iSynchronisationApplication.class, args);
	}

}
