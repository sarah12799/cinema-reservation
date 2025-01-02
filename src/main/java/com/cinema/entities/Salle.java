package com.cinema.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "SALLE")
public class Salle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_salle;

    private String name;
    private String adress;
    private Integer capacite;

    @OneToOne(mappedBy = "SALLE")
    private SalleProg salleProg;
   
   

    public Salle() {
        super();
    }

    public Salle(Integer id, String name, String adress, Integer capacite, SalleProg salleProg) {
        this.id_salle = id;
        this.name = name;
        this.adress = adress;
        this.capacite = capacite;
        this.salleProg = salleProg;
    }

    // Getters and setters
    public Integer getId() {
        return id_salle;
    }

    public void setId(Integer id) {
        this.id_salle = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public Integer getCapacite() {
        return capacite;
    }

    public void setCapacite(Integer capacite) {
        this.capacite = capacite;
    }
    
    public SalleProg getSalleProg() {
        return salleProg;
    }

    public void setSalleProg(SalleProg salleProg) {
        this.salleProg = salleProg;
    }
}
