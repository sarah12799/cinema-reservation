package com.cinema.entities;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.Column;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "SALLE_PROG")
public class SalleProg implements Serializable {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Integer id_salleprog;

    @ManyToOne
    @JoinColumn(name = "id_film")
    private Film film;

    @OneToOne
    @JoinColumn (name="id_salle")
    private Salle salle;
    
    /**private Salle salle;
    @OneToOne(mappedBy = "salleProg")*/

    @OneToMany(mappedBy = "salleProg", cascade = CascadeType.ALL)
    private Set<Seance> seances;


    public SalleProg() {
        super();
    }

    public Integer getId() {
        return id_salleprog;
    }

    public void setId(Integer id) {
        this.id_salleprog = id;
    }

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
        result = prime * result + ((id_salleprog == null) ? 0 : id_salleprog.hashCode());
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
        if (id_salleprog == null) {
            if (other.id_salleprog != null)
                return false;
        } else if (!id_salleprog.equals(other.id_salleprog))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "SalleProg [id=" + id_salleprog + ", film=" + film + "]";
    }
}
