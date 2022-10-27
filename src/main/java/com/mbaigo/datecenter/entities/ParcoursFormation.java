package com.mbaigo.datecenter.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity @Data  @NoArgsConstructor
public class ParcoursFormation {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "formation_id")
    private Formation formation;
    @ManyToOne
    @JoinColumn(name = "parcours_id")
    private Parcours parcours;
}
