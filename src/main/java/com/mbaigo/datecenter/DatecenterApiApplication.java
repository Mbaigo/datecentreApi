package com.mbaigo.datecenter;

import com.mbaigo.datecenter.controller.InscriptionController;
import com.mbaigo.datecenter.dao.*;
import com.mbaigo.datecenter.entities.*;
import com.mbaigo.datecenter.services.ApprenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.Date;

@SpringBootApplication
public class DatecenterApiApplication {
    @Autowired
    private RepositoryRestConfiguration repositoryRestConfiguration;

	public static void main(String[] args) {
		SpringApplication.run(DatecenterApiApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(ApprenantRepository apprenantRepository,
								  FormationRepository formationRepository,
								  InscriptionRepository inscriptionRepository,
								  ParcoursRepository parcourtRepository,
								  ParcoursFormationRepository parcourtFormationRepository,
								  ApprenantService service,
								  InscriptionController controller) {
        //cette ligne permet d'exposer les id des classes
        repositoryRestConfiguration.exposeIdsFor(Apprenant.class, Inscription.class,Formation.class,
                Parcours.class);
		return (args) -> {
/*			Apprenant apprenant = new Apprenant();


			apprenant.setName("Frederic");
			apprenant.setLastName("Julien");
			apprenant.setEmail("mbaihogunon@gmail.com");
			apprenant.setPhoneNumber("88889999");
			apprenant.setCreated(new Date());
			service.saveApprenant(apprenant);


			Formation f = new Formation();
			f.setTitle("NodeJS");
			f.setDescription("Le python pour le web");
			f.setCout(3564.0);
			f.setVolumeHoraire(60);
			formationRepository.save(f);

			Inscription i= new Inscription();
			i.setApprenant(apprenant);
			i.setFormation(f);
			i.setDateInscritpion(new Date());
			i.setMontant(f.getCout());
			i.setVersement(564.0);
			controller.saveInscription(i);

			Parcours p= new Parcours();

			p.setTitle("ExpressJS");
			p.setDescription("Mise en forme de l'interface graphique");
			p.setVolumeHoraire(10);
			p.setFormation(f);
			parcourtRepository.save(p);

			ParcoursFormation pf = new ParcoursFormation();
			pf.setFormation(f);
			pf.setParcours(p);
			parcourtFormationRepository.save(pf);



*/
			//apprenantRepository.save(apprenant);
			parcourtFormationRepository.findAll().forEach(fp->System.out.println(fp.getFormation().getTitle()+" "+fp.getParcours().getTitle()));
			apprenantRepository.findAll().forEach(a->System.out.println(a.getId()+ " "+a.getName()+" "+a.getLastName()));

		};
	}
}
