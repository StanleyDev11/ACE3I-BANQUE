package com.ace3i.ace3i_paiement.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "EPPAI") // Convention ACE3i
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Paiement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "La date de paiement est obligatoire.")
    @Column(name = "PAIDAT")
    private LocalDate datePaiement;

    @Positive(message = "Le montant doit être positif.")
    @Column(name = "PAIMON")
    private double montant;

    @NotBlank(message = "Le code client est obligatoire.")
    @Column(name = "PAICOD", length = 6)
    private String codeClient;

    @NotBlank(message = "La référence de facture est obligatoire.")
    @Column(name = "PAIFAC")
    private String numeroFacture;

    @NotNull(message = "Le mode de paiement est obligatoire.")
    @Enumerated(EnumType.STRING)
    @Column(name = "PAIMOD")
    private ModePaiement modePaiement;
}
