package com.mbaigo.datecenter.services;

import com.mbaigo.datecenter.dao.ApprenantRepository;
import com.mbaigo.datecenter.entities.Apprenant;
import com.mbaigo.datecenter.entities.Formation;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;
@Data
@Service
@AllArgsConstructor
public class ApprenantService {
    @Autowired
    private ApprenantRepository repository;

    public Apprenant saveApprenant(Apprenant apprenant){
        Apprenant p = repository.save(apprenant);
        return p;
    }

    public Iterable<Apprenant> getApprenants(){
        return  repository.findAll();
    }

    public Optional<Apprenant> getApprenant(final Long id){
        return repository.findById(id);
    }

    public Iterable<Apprenant> getByNameContains(String key){
        return repository.findByNameContains(key);
    }

    public void delete(final Long apprenant){
        repository.deleteById(apprenant);
    }

    public Iterable<Apprenant> getByName(String name){
        return repository.findByName(name);
    }

    public Optional<Apprenant> getByPhoneNumber(String phone){
        return repository.findByPhoneNumber(phone);
    }

    public Optional<Apprenant> getByEmail(String email){
        return repository.findByEmailContains(email);
    }

    public Iterable<Apprenant> getByLastName(String lastName){
        return repository.findByLastName(lastName);
    }

    public Optional<Apprenant> updateFormation(Long id, Apprenant apprenant){
        Apprenant app= repository.findById(id).get();
        app.setName(apprenant.getName());
        app.setLastName(apprenant.getLastName());
        app.setBirthday(apprenant.getBirthday());
        app.setEmail(apprenant.getEmail());
        app.setPhoneNumber(apprenant.getPhoneNumber());
        repository.save(app);
        return Optional.of(app);
    }


   // @GetMapping("/apprenants/search/apprenantsByKeyword")
    public Iterable<Apprenant> getNameContains(@Param("name") String name){
        return repository.findByNameContains(name);
    }

    //@DeleteMapping("/apprenants/{id}")
    public String deletById(@PathVariable Long id){
        repository.deleteById(id);
        return "apprenant dont le id est "+id+" a ete supprimer";
    }

}
