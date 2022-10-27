package com.mbaigo.datecenter.services;

import com.mbaigo.datecenter.dao.ParcoursFormationRepository;
import com.mbaigo.datecenter.entities.ParcoursFormation;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service @Data
public class ParcoursFormationService {

    @Autowired
    private ParcoursFormationRepository repository;

    public List<com.mbaigo.datecenter.entities.ParcoursFormation> getAll(){
        return repository.findAll();
    }

    public Optional<ParcoursFormation> getParcoursFormationById(Long id){
        return repository.findById(id);
    }

    public Optional<ParcoursFormation> update(Long id, ParcoursFormation pf){
        ParcoursFormation parf= repository.findById(id).get();
        parf.setParcours(pf.getParcours());
        parf.setFormation(pf.getFormation());
        repository.save(parf);
        return Optional.of(parf);
    }

    public ParcoursFormation save(ParcoursFormation pf){
        return repository.save(pf);
    }

    public void deleteParcoursFormation(Long id){
        repository.deleteById(id);
    }

    public Iterable<ParcoursFormation> getParcoursFormationByParcoursTitle(String title){
        return repository.findByParcoursTitle(title);
    }

    public Iterable<ParcoursFormation> getParcoursFormationByFormationTitle(String title){
        return repository.findByFormationTitle(title);
    }
}
