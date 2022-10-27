package com.mbaigo.datecenter.controller;

import com.mbaigo.datecenter.entities.ParcoursFormation;
import com.mbaigo.datecenter.services.ParcoursFormationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
public class ParcoursFormationController {

    @Autowired
    private ParcoursFormationService service;

    @GetMapping("/api/parcoursformations")
    public Iterable<ParcoursFormation> getAll(){
        return service.getAll();
    }

    @GetMapping("/api/parcoursformations/{id}")
    public Optional<ParcoursFormation> getById(Long id){
        return service.getParcoursFormationById(id);
    }

    @GetMapping("/api/parcoursformations/search/pfByFormationTitle")
    public Iterable<ParcoursFormation> getByFormationTitle(@Param("title") String title){
        return service.getParcoursFormationByFormationTitle(title);
    }

    @GetMapping("/api/parcoursformations/search/pfByParcoursTitle")
    public Iterable<ParcoursFormation> getByParcoursTitle(@Param("title") String title){
        return service.getParcoursFormationByFormationTitle(title);
    }

    @PostMapping("/api/parcoursformations")
    public ParcoursFormation addPF(@RequestBody ParcoursFormation pf){
        return service.save(pf);
    }

    @PutMapping("/api/parcoursformations/{id}")
    public Optional<ParcoursFormation> updateParcoursFormation(@PathVariable Long id, @RequestBody ParcoursFormation pf){
        return service.update(id,pf);
    }
}
