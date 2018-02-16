package com.example.topcolleguesbackend.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.topcolleguesbackend.entite.Collegue;
import com.example.topcolleguesbackend.repository.CollegueRepository;


@RestController
@RequestMapping("/collegues")
@CrossOrigin
public class CollegueController {

	@Autowired
	CollegueRepository collegueRepo;

	@GetMapping
	public List<Collegue> listerCollegues() {

		return collegueRepo.findAll();

	}
	
	@RequestMapping(method = RequestMethod.GET, value="detail/{pseudo}")
	public Collegue findCollegue(@PathVariable String pseudo) {
		return collegueRepo.findByNom(pseudo);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> saveCollegue(@RequestBody Collegue collegue) {
		
		//verifier si le pseudo existe deja
		Collegue collegueExist = collegueRepo.findByNom(collegue.getNom());
		
		if(collegueExist != null) {
			//le pseudo est deja pris
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ce pseudo est déjà utilisé");
		}
		else {
			//verification imgUrl pour mettre image par défault
			if(collegue.getImgUrl().equals("")) {
				collegue.setImgUrl("assets/namelessG.jpg");
			}
			collegueRepo.save(collegue);
		}
		
		List<Collegue> listCollegues = collegueRepo.findAll();
		return ResponseEntity.ok(listCollegues);
	}
	
	@RequestMapping(method = RequestMethod.PATCH, value="/{pseudo}")
	public Collegue updateCollegue(@RequestBody HashMap<String, String> action, @PathVariable String pseudo) {
		
		Collegue collegueToUpdate = collegueRepo.findByNom(pseudo);
		
		if(collegueToUpdate != null) {
			if(action.get("action").equals("aimer")) {
				collegueToUpdate.setScore(collegueToUpdate.getScore()+10);
			}
			else if(action.get("action").equals("detester")) {
				collegueToUpdate.setScore(collegueToUpdate.getScore()-10);
			}
			collegueRepo.save(collegueToUpdate);
		}
		//retourne collegue updaté ou non
		Collegue resCollegue = collegueRepo.findByNom(pseudo);
		return resCollegue;
	}

}
