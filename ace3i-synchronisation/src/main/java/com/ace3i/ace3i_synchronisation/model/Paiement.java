package com.ace3i.ace3i_synchronisation.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "paiements")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Paiement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "La date de paiement est obligatoire.")
    private LocalDate datePaiement;

    @Positive(message = "Le montant doit être positif.")
    private double montant;

    @NotBlank(message = "Le code client est obligatoire.")
    @Column(length = 6)
    private String codeClient;

    @NotBlank(message = "La référence de facture est obligatoire.")
    private String numeroFacture;

    @NotNull(message = "Le mode de paiement est obligatoire.")
    @Enumerated(EnumType.STRING)
    private ModePaiement modePaiement;
}
