package com.cinema.entities;

import java.io.Serializable;
import java.util.Set;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "FILM")
public class Film implements Serializable {

    private Integer id;
    private String nom;
    private Set<SalleProg> salleProgs;

    public Film() {
        super();
    }
    public Film(Integer id,String nom, Set<SalleProg> salleProgs) {
    	super();
		this.id = id;
		this.nom=nom;
        this.salleProgs = salleProgs;
    }

    @Id
    @GeneratedValue
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "NOM_FILM")
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @OneToMany(mappedBy = "film", cascade = CascadeType.PERSIST)
    public Set<SalleProg> getSalleProgs() {
        return salleProgs;
    }

    public void setSalleProgs(Set<SalleProg> salleProgs) {
        this.salleProgs = salleProgs;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((salleProgs == null) ? 0 : salleProgs.hashCode());
        result = prime * result + id;
        result = prime * result + ((nom == null) ? 0 : nom.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Film other = (Film) obj;
        if (salleProgs == null) {
            if (other.salleProgs != null)
                return false;
        } else if (!salleProgs.equals(other.salleProgs))
            return false;
        if (id != other.id)
            return false;
        if (nom == null) {
            if (other.nom != null)
                return false;
        } else if (!nom.equals(other.nom))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Film [id=" + id + ", nom=" + nom + ", salleProgs=" + salleProgs + "]";
    }
}
