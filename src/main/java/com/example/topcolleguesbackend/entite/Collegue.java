package com.example.topcolleguesbackend.entite;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="COLLEGUE")
public class Collegue {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="NOM")
	private String nom;
	
	@Column(name="IMAGE_URL")
	private String imgUrl;
	
	@Column(name="SCORE")
	private Integer score;
	
	@OneToMany(mappedBy="collegue")
	private Set<Avis> avis;
	
	//constructor
	public Collegue(){
		avis = new HashSet<Avis>();
	}
	
	public Collegue(String pseudo, String imageUrl, Integer score) {
		this.nom = pseudo;
		this.imgUrl = imageUrl;
		this.score = score;
	}
	
	//getters and setters

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String pseudo) {
		this.nom = pseudo;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imageUrl) {
		this.imgUrl = imageUrl;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public Set<Avis> getAvis() {
		return avis;
	}

	public void setAvis(Set<Avis> avis) {
		this.avis = avis;
	}
	
}
