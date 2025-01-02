package com.cinema.entities;

import java.io.Serializable;
import java.util.Set;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "FILM")
public class Film implements Serializable {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idFilm")
	private int id_film ;
	@Column(name="nomFILM")
    private String nom;
	@OneToMany(mappedBy = "film", cascade = CascadeType.PERSIST)
    private Set<SalleProg> salleProgs;

	public Film(String nom) {
		this.nom=nom;
	}
	
	public Film(int id_film, String nom) {
		super();
		this.id_film = id_film;
		this.nom = nom;
	}

    @Id
    
    public Integer getId() {
        return id_film;
    }

    public void setId(Integer id) {
        this.id_film = id;
    }

    
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    
    
    

    @Override
    public String toString() {
        return "Film [id=" + id + ", nom=" + nom + ", salleProgs=" + salleProgs + "]";
    }
}
