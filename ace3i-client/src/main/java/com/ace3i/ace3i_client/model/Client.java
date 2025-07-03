package com.ace3i.ace3i_client.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Table(name = "clients")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Client {

    @Id
    @Column(length = 6, unique = true, nullable = false)
    @Size(min = 6, max = 6, message = "Le code client doit contenir exactement 6 caractères.")
    private String codeClient;

    @NotBlank(message = "Le nom est obligatoire.")
    private String nom;

    @NotBlank(message = "Le prénom est obligatoire.")
    private String prenom;

    @Column(length = 18, nullable = false, unique = true)
    @Size(min = 18, max = 18, message = "Le numéro de compte doit contenir exactement 18 chiffres.")
    private String numeroCompte;

    @PositiveOrZero(message = "Le solde doit être positif ou nul.")
    private double solde;

}
