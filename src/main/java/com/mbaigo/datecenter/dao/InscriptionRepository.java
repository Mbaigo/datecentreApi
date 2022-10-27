package com.mbaigo.datecenter.dao;

import com.mbaigo.datecenter.entities.Inscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InscriptionRepository extends JpaRepository<Inscription, Long> {

    public List<Inscription> findByApprenantName(String name);

    public List<Inscription> findByFormationTitle( String name);

    public List<Inscription> findByFormationCout(double name);

    public List<Inscription> findByApprenantLastName(String name);

    public List<Inscription> findByMontant( double name);

    public Iterable<Inscription> findByApprenantEmail(String email);

    public Inscription findByApprenantPhoneNumber(String phone);
}