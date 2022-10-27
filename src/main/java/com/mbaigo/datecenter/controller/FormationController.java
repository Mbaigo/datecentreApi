package com.mbaigo.datecenter.controller;

import com.mbaigo.datecenter.entities.Formation;
import com.mbaigo.datecenter.services.FormationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:4200/")
public class FormationController {
    @Autowired
    private FormationService service;

    @GetMapping("/api/formations")
    public Iterable<Formation> getFormations(){
        return  service.getFormations();
    }

    @PostMapping("/api/formations")
    public Optional<Formation> savePackModule(@RequestBody Formation module){
        return service.addFormation(module);
    }
    @PutMapping("/api/formations/{id}")
    public Optional<Formation> update(@PathVariable Long id, @RequestBody Formation formation){
        return service.updateFormation(id, formation);
    }
    @GetMapping("/api/formations/{id}")
    public Optional<Formation> getById(@PathVariable Long id){
        return service.getById(id);
    }

    @GetMapping("/api/formations/search/formationsByTitle")
    public Optional<Formation> getByTitle(@Param("name") String title){
        return service.getByTitle(title);
    }

    @DeleteMapping("/api/formations/{id}")
    public  String deleteFormationById(@PathVariable Long id){
        service.deletFormation(id);
        return "Vous avez supprimer la formation "+id;
    }
}
