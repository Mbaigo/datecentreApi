package com.mbaigo.datecenter.services;

import com.mbaigo.datecenter.dao.InscriptionRepository;
import com.mbaigo.datecenter.entities.Inscription;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

@Service @Data
public class InscriptionService {
    @Autowired
    private InscriptionRepository repository;

    public Iterable<Inscription> getAll(){
        return repository.findAll();
    }

    public Iterable<Inscription> getByApprenantEmail(String email){
        return repository.findByApprenantEmail(email);
    }

    public Optional<Inscription> getById(Long id){
        return repository.findById(id);
    }

    public Optional<Inscription> getByApprenantPhone(String phone){
        return Optional.ofNullable(repository.findByApprenantPhoneNumber(phone));
    }

    public Iterable<Inscription> getByFormationTitle(String title){
        return repository.findByFormationTitle(title);
    }

    public Inscription saveInscription(Inscription inscription){
        inscription.setDateInscritpion(LocalDate.now());
        inscription.setMontant(inscription.getFormation().getCout());
        inscription.setRestPaiement(inscription.getMontant()-inscription.getVersement());
        return repository.save(inscription);
    }

    public Optional<Inscription> updateInscritpion(Long id, Inscription inscription){
        Inscription ins =repository.findById(id).get();
        ins.setRestPaiement(inscription.getRestPaiement());
        ins.setVersement(inscription.getVersement());
        ins.setMontant(inscription.getMontant());
        ins.setRestPaiement(inscription.getRestPaiement());
        repository.save(ins);
        return Optional.of(ins);
    }

    public Iterable<Inscription> getByApprenantName(String name){
        return repository.findByApprenantName(name);
    }
//paiement des frais
    public void versementFrais(Long id,Inscription inscription){
        double montantInit, versementInit;
        Inscription inscript = repository.findById(id).get();
        montantInit=inscript.getMontant();
        versementInit=inscript.getVersement();
        try {
            if((montantInit-versementInit)!=0){
                if (inscription.getVersement()<=inscript.getRestPaiement()){
                    inscript.setVersement(inscript.getVersement()+inscription.getVersement());
                    inscript.setRestPaiement(inscript.getRestPaiement()- inscription.getVersement());
                } else{
                    System.out.println("vous devez entrez un monntant ne depassant pas" +inscript.getRestPaiement());
                }
            }else{
                System.out.println("Votre solde est null");
            }
        }catch (Exception e){
            System.out.println(e);
        }
        repository.save(inscript);
    }

}
