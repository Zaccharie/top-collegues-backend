package com.example.topcolleguesbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.topcolleguesbackend.entite.Avis;
import com.example.topcolleguesbackend.entite.Collegue;
import com.example.topcolleguesbackend.repository.AvisRepository;
import com.example.topcolleguesbackend.repository.CollegueRepository;

@RestController
@RequestMapping("/avis")
@CrossOrigin
public class AvisController {
	
	@Autowired
	AvisRepository avisRepo;
	
	@Autowired
	CollegueRepository collegueRepo;

	@GetMapping
	public List<Avis> listerAvis() {
		return avisRepo.findAll();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> ajouterAvis(@RequestBody Avis avis){
		
		//recuperer le collegue
		Collegue co = collegueRepo.findByNom(avis.getCollegue().getNom());
		
		if(co == null) {
			//Impossible de retrouver le collegue dans la base
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Impossible de trouver le collegue...");
		}
		else {
			avisRepo.save(avis);
		}
		return ResponseEntity.ok(co);
	}
	
}
