package com.mbaigo.datecenter.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data @NoArgsConstructor
public class Inscription {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //private String rang;
    //prix de la formation
    private double montant;
    @JsonFormat(pattern = "dd-MM-yy")
    private LocalDate dateInscritpion;
    //montant versé
    private Double versement;
    //reste de paiement
    private Double restPaiement;
    private boolean solder;
    @ManyToOne
    private Formation formation;
    @ManyToOne
    private Apprenant apprenant;
}
