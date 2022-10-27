package com.mbaigo.datecenter.controller;

import com.mbaigo.datecenter.entities.Inscription;
import com.mbaigo.datecenter.services.InscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
public class InscriptionController {

    @Autowired
    private InscriptionService service;

    @GetMapping("/api/inscriptions")
    public Iterable<Inscription> getAll(){
        return service.getAll();
    }

    @PostMapping("/api/inscriptions")
    public Inscription saveInscription(@RequestBody Inscription inscription){
      return service.saveInscription(inscription);
    }
    @GetMapping("/api/inscriptions/{id}")
    public Optional<Inscription> getById(@PathVariable Long id){
        return service.getById(id);
    }

    @GetMapping("/api/inscriptions/search/findByApprenantEmail")
    public Iterable<Inscription> findByApprenantEmail(@Param("email") String email){
        return service.getByApprenantEmail(email);
    }


    @GetMapping("/api/inscriptions/search/findByApprenantName")
    public Iterable<Inscription> findByApprenantName(@Param("name") String name){
        return service.getByApprenantName(name);
    }
    @PatchMapping("/api/inscriptions/payment/{id}")
    public void onPayment(@PathVariable Long id, @RequestBody Inscription inscription){
        service.versementFrais(id,inscription);
    }
}
