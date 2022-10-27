package com.mbaigo.datecenter.dao;

import com.mbaigo.datecenter.entities.ParcoursFormation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParcoursFormationRepository extends JpaRepository<ParcoursFormation, Long> {

    public Iterable<ParcoursFormation> findByParcoursTitle(String title);

    public  Iterable<ParcoursFormation> findByFormationTitle(String title);
}
