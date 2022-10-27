package com.mbaigo.datecenter.controller;

import com.mbaigo.datecenter.entities.Apprenant;
import com.mbaigo.datecenter.services.ApprenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.Optional;

@CrossOrigin("http://localhost:4200/")
@RestController
@RequestMapping("/datecenter")
public class ApprenantController {
    @Autowired
    private ApprenantService service;

    @GetMapping("/api/apprenants/search/apprenantsByKeyword")
    public Iterable<Apprenant> getNameContains(@Param("name") String name){
        return service.getNameContains(name);
    }

    @GetMapping("/api/apprenants/search/apprenantsByLastName")
    public Iterable<Apprenant> getByLastName(@Param("lastName") String lastName){
        return  service.getByLastName(lastName);
    }

    //upload images
    @PostMapping("/api/apprenants/uploadImage")
    public String uploadImage(@RequestParam("file")MultipartFile file){
        System.out.println(file.getOriginalFilename());
        System.out.println(file.getName());
        System.out.println(file.getContentType());
        System.out.println(file.getSize());

    return "Upload succesfull!";
    }

    @GetMapping("/api/apprenants")
    public Iterable<Apprenant> getApprenants(){
        return service.getApprenants();
    }

    @PostMapping("/api/apprenants")
    public Apprenant addApprenant(@RequestBody Apprenant apprenant){
        apprenant.setCreated(new Date());
        return service.saveApprenant(apprenant);
    }

    @PutMapping("/api/apprenants/{id}")
    public Optional<Apprenant> updateApprenant(@PathVariable Long id, @RequestBody Apprenant apprenant) {
        return service.updateFormation(id, apprenant);
    }
    @GetMapping("/api/apprenants/{id}")
    public Optional<Apprenant> getApprenant(@PathVariable(name="id") Long id){
        return service.getApprenant(id);
    }

    @GetMapping("/api/apprenants/search/apprenantsByName")
    public Iterable<Apprenant> getByName(@Param("name") String name){
        return service.getByName(name);
    }

    @DeleteMapping("/api/apprenants/{id}")
    public String deletById(@PathVariable Long id){
        return service.deletById(id);
    }

    @GetMapping("/api/apprenants/search/apprenantByEmail")
    public Optional<Apprenant> getByEmail( String name){
        return service.getByEmail(name);
    }

    @GetMapping("/api/apprenants/search/apprenantByPhoneNumber")
    public Optional<Apprenant> getByPhoneNumber(@Param("phone") String phone){
        return service.getByPhoneNumber(phone);
    }

}
