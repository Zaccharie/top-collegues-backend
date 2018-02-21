package com.example.topcolleguesbackend.web.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.example.topcolleguesbackend.entite.Avis;
import com.example.topcolleguesbackend.entite.Collegue;
import com.example.topcolleguesbackend.repository.AvisRepository;
import com.example.topcolleguesbackend.repository.CollegueRepository;

@Component
public class StartUpAppListener {
	
	@Autowired
	private CollegueRepository collegueRepo;
	
	@Autowired
	private AvisRepository avisRepo;	
	
	@EventListener(ContextRefreshedEvent.class)
	public void contextRefreshedEvent() {
		// capture du démarrage de l'application
		// à un moment où le contexte Spring est complètement créé

		//generer jeu de données avec departements et collaborateurs
		Collegue c1 = new Collegue("Zaccharie","assets/namelessG.jpg", 10);
		Collegue c2 = new Collegue("Jordan","assets/namelessG.jpg", 0);
		Collegue c3 = new Collegue("Rossi","assets/namelessG.jpg", 0);
		Collegue c4 = new Collegue("Richard","assets/namelessG.jpg", 0);
		Collegue c5 = new Collegue("Francois","assets/namelessG.jpg", 0);
		
		Avis av1 = new Avis(c1, "test: Zac est trop cool");
		
		collegueRepo.save(c1);
		collegueRepo.save(c2);
		collegueRepo.save(c3);
		collegueRepo.save(c4);
		collegueRepo.save(c5);
		
		avisRepo.save(av1);
	}

}