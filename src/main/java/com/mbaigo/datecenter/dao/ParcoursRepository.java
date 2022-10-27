package com.mbaigo.datecenter.dao;

import com.mbaigo.datecenter.entities.Parcours;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ParcoursRepository extends JpaRepository<Parcours, Long> {
    public Optional<Parcours> findByTitle(String title);
    //public Iterable<Parcours> findByFormationTitle(String title);
}