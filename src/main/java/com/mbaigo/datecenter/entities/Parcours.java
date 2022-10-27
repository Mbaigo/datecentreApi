package com.mbaigo.datecenter.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity @Data  @NoArgsConstructor @AllArgsConstructor
public class Parcours {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private Integer volumeHoraire;/*
    @ManyToOne
    private Formation formation;*/
}
