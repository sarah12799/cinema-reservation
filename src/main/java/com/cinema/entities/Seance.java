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
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import java.util.Date;

@Entity
public class Seance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_seance;

    @Temporal(TemporalType.TIMESTAMP)
    private Date horaire;

    private Integer places;
    private Float tarif;

    @ManyToOne
    @JoinColumn(name = "id_salleprog")
    private SalleProg salleProg;

    // Constructeur par défaut
    public Seance() {
    	super();
    }

    // Constructeur paramétré
    public Seance(Date horaire, Integer places, Float tarif, Integer id_seance) {
        this.horaire = horaire;
        this.places = places;
        this.tarif = tarif;
        this.id_seance = id_seance;
    }

    // Getters and setters
    public Integer getId() {
        return id_seance;
    }

    public void setId(Integer id) {
        this.id_seance = id;
    }

    public Date getHoraire() {
        return horaire;
    }

    public void setHoraire(Date horaire) {
        this.horaire = horaire;
    }

    public int getPlaces() {
        return places;
    }

    public void setPlaces(int places) {
        this.places = places;
    }

    public float getTarif() {
        return tarif;
    }

    public void setTarif(float tarif) {
        this.tarif = tarif;
    }

    public SalleProg getSalleProg() {
        return salleProg;
    }

    public void setSalleProg(SalleProg salleProg) {
        this.salleProg = salleProg;
    }
}

