package com.mbaigo.datecenter.dao;

import com.mbaigo.datecenter.entities.Apprenant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Optional;

@Repository
public interface ApprenantRepository extends JpaRepository<Apprenant, Long> {

    //@RestResource(path = "/apprenantByKeyword")
    public List<Apprenant> findByNameContains( String keyWord);

   // @RestResource(path = "/apprenantByLastName")
    public List<Apprenant> findByLastName(String name);

  //  @RestResource(path = "/apprenantByName")
    public Iterable<Apprenant> findByName( String name);

   // @RestResource(path = "/apprenantByPhoneNumber")
    public Optional<Apprenant> findByPhoneNumber( String phone);

    //@RestResource(path = "/apprenantByEmail")
    public Optional<Apprenant> findByEmailContains(String email);
    //@RestResource(path = "/apprenants")
    public Apprenant save(Apprenant apprenant);

}