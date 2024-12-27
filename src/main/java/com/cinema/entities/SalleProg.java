package com.cinema.entities;



import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.OneToOne;

@Entity
@Table(name = "SALLE_PROG")
public class SalleProg implements Serializable {
	@ManyToOne
    @JoinColumn(name = "film_id")
    private Film film;

    @OneToOne(mappedBy="salleProg")//choix esclave est salleprog ici
    private Salle salle;

    @OneToMany(mappedBy = "salleProg", cascade = CascadeType.ALL)
    private Set<Seance> seances;

    private Integer id;
    

    public SalleProg() {
        super();
    }
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "FILM_ID")
    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }
    public Salle getSalle() {
        return salle;
    }

    public void setSalle(Salle salle) {
        this.salle = salle;
    }

    public Set<Seance> getSeances() {
        return seances;
    }

    public void setSeances(Set<Seance> seances) {
        this.seances = seances;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
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
        SalleProg other = (SalleProg) obj;
        if (id != other.id)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "SalleProg [id=" + id + ", film=" + film + "]";
    }
}

