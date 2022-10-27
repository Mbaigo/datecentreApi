package com.mbaigo.datecenter.web;

import java.nio.file.Files;
import java.nio.file.Paths;

import com.mbaigo.datecenter.dao.ApprenantRepository;
import com.mbaigo.datecenter.entities.Apprenant;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class EcomRestController {
	private ApprenantRepository produitRepository;

	public EcomRestController(ApprenantRepository produitRepository) {
		super();
		this.produitRepository = produitRepository;
	}
	//Methode d'affichage des images
	@GetMapping(path="/photoProduct/{id}", produces = MediaType.IMAGE_JPEG_VALUE)
	public byte[] getPhoto(@PathVariable("id")Long id) throws Exception {
		Apprenant p=produitRepository.findById(id).get();
		return Files.readAllBytes(Paths.get(System.getProperty("user.home")+ "/Ecom/Produit/"+p.getPicture()));
	}

}
