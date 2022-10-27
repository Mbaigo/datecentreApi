package com.mbaigo.datecenter.services;

import com.mbaigo.datecenter.dao.FormationRepository;
import com.mbaigo.datecenter.entities.Formation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FormationService {
    @Autowired
    private FormationRepository repository;

    public Iterable<Formation> getFormations(){
        return repository.findAll();
    }

    public Optional<Formation> addFormation(Formation module){
        Formation p =repository.save(module);
        return Optional.of(p);
    }

    public Optional<Formation> updateFormation(Long id, Formation formation){
        Formation f= repository.findById(id).get();
        f.setTitle(formation.getTitle());
        f.setDescription(formation.getDescription());
        f.setVolumeHoraire(formation.getVolumeHoraire());
        f.setCout(formation.getCout());
        repository.save(f);
        return Optional.of(f);
    }

    public  void deletFormation(Long id){
        repository.deleteById(id);
    }

    public Optional<Formation> getByTitle(String title){
        return repository.findByTitle(title);
    }

    public Optional<Formation> getById(Long id){
        return repository.findById(id);
    }
}
