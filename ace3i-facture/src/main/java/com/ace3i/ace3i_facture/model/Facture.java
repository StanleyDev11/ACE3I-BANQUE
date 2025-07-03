package com.ace3i.ace3i_facture.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Table(name = "factures")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Facture {

    @Id
    @Column(length = 50, nullable = false, unique = true)
    @NotBlank(message = "La référence est obligatoire.")
    private String reference;

    @NotBlank(message = "La description est obligatoire.")
    private String description;

    @Positive(message = "Le montant doit être strictement positif.")
    private double montant;

    @NotBlank(message = "Le nom du facturier est obligatoire.")
    private String facturier;
}
