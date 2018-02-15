package com.example.topcolleguesbackend.web.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.example.topcolleguesbackend.entite.Collegue;
import com.example.topcolleguesbackend.repository.CollegueRepository;

@Component
public class StartUpAppListener {
	
	@Autowired
	private CollegueRepository collegueRepo;
	
	@EventListener(ContextRefreshedEvent.class)
	public void contextRefreshedEvent() {
		// capture du démarrage de l'application
		// à un moment où le contexte Spring est complètement créé

		//generer jeu de données avec departements et collaborateurs
		Collegue c1 = new Collegue("Zaccharie","https://mbevivino.files.wordpress.com/2011/08/silhouette_i-m-congnito.jpg", 10);
		Collegue c2 = new Collegue("Jordan","https://mbevivino.files.wordpress.com/2011/08/silhouette_i-m-congnito.jpg", 0);
		Collegue c3 = new Collegue("Rossi","https://mbevivino.files.wordpress.com/2011/08/silhouette_i-m-congnito.jpg", 0);
		Collegue c4 = new Collegue("Richard","https://mbevivino.files.wordpress.com/2011/08/silhouette_i-m-congnito.jpg", 0);
		Collegue c5 = new Collegue("Francois","https://mbevivino.files.wordpress.com/2011/08/silhouette_i-m-congnito.jpg", 0);
		
		collegueRepo.save(c1);
		collegueRepo.save(c2);
		collegueRepo.save(c3);
		collegueRepo.save(c4);
		collegueRepo.save(c5);
	}

}