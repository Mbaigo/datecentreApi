package com.mbaigo.datecenter.dao;

import com.mbaigo.datecenter.entities.Formation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FormationRepository extends JpaRepository<Formation, Long> {
    public Optional<Formation> findByTitle( String title);
}