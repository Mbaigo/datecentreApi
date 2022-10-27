package com.mbaigo.datecenter.controller;

import com.mbaigo.datecenter.entities.Parcours;
import com.mbaigo.datecenter.services.ParcoursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:4200/")
public class ParcoursController {

    @Autowired
    private ParcoursService service;

    @GetMapping("/api/parcours")
    public Iterable<Parcours> getParcours(){
        return  service.getParcours();
    }

    @GetMapping("/api/parcours/{id}")
    public Optional<Parcours> getParcoursById(@PathVariable Long id){
        return service.getParcousById(id);
    }

    @GetMapping("/api/parcours/search/parcoursByTitle")
    public Optional<Parcours> getParcoursByTitle(@Param("title") String title){
        return service.getParcourtByTitle(title);
    }

/*    @GetMapping("/api/parcours/search/parcoursByFormationTitle")
    public Iterable<Parcours> getParcoursByFormationTitle(@Param("title") String title){
        return service.getByFormationTitle(title);
    }*/

    @DeleteMapping("/api/parcours/{id}")
    public String deleteParcoursById(@PathVariable Long id){
        service.deleteParcoursById(id);
        return "le parcours dont le id est "+id+" a été supprimé";
    }

    @PostMapping("/api/parcours")
    public Optional<Parcours> addParcours(@RequestBody Parcours parcours){
        return  service.addParcours(parcours);
    }

    @PutMapping("/api/parcours/{id}")
    public Optional<Parcours> update(@PathVariable Long id, @RequestBody Parcours parcourt){
        return service.updateParcout(id,parcourt);
    }

}
