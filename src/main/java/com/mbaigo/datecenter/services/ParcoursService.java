package com.mbaigo.datecenter.services;

import com.mbaigo.datecenter.dao.ParcoursRepository;
import com.mbaigo.datecenter.entities.Parcours;
import com.mbaigo.datecenter.entities.Parcours;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ParcoursService {

    @Autowired
    private ParcoursRepository repository;

    public Iterable<Parcours> getParcours(){
        return repository.findAll();
    }

    public Optional<Parcours> getParcousById(Long id){
        return repository.findById(id);
    }

    public Optional<Parcours> getParcourtByTitle(String title){
        return repository.findByTitle(title);
    }

    public  Optional<Parcours> addParcours(Parcours parcourt){
        repository.save(parcourt);
        return Optional.of(parcourt);
    }

    public Optional<Parcours> updateParcout(Long id, Parcours parcourt){
        Parcours p = repository.findById(id).get();
        p.setTitle(parcourt.getTitle());
        p.setVolumeHoraire(parcourt.getVolumeHoraire());
        p.setDescription(parcourt.getDescription());
        repository.save(p);
        return Optional.of(p);
    }

   /* public Iterable<Parcours> getByFormationTitle(String title){
        return repository.findByFormationTitle(title);
    }*/

    public void deleteParcoursById(Long id){
        repository.deleteById(id);
    }
}
