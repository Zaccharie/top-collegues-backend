package com.example.topcolleguesbackend.entite;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name="AVIS")
public class Avis {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="COMMENTAIRE")
	private String commentaire;
	
	@ManyToOne
	@JoinColumn(name="COL_ID")
	@JsonProperty(access = Access.WRITE_ONLY)
	private Collegue collegue;
	
	//constructor
	public Avis() {
		
	}
	
	public Avis(Collegue co, String commentaire ) {
		this.collegue  = co;
		this.commentaire = commentaire;
	}
	
	//getters and setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
	//@JsonIgnore
	public Collegue getCollegue() {
		return collegue;
	}

	public void setCollegue(Collegue collegue) {
		this.collegue = collegue;
	}
	
}
