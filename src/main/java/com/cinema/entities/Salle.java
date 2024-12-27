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
@Table(name = "SALLE")
public class Salle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String adress;
    private Integer capacite;

    @OneToOne
    @JoinColumn(name = "salleProg_id")
    private SalleProg salleProg;
    public Salle() {
        super();
    }
    public Salle(Integer id,String name, String adress, Integer capacite, SalleProg salleProg) {
        this.name = name;
        this.adress = adress;
        this.capacite = capacite;
        this.salleProg = salleProg;
    }
    // Getters and setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public int getCapacite() {
        return capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    public SalleProg getSalleProg() {
        return salleProg;
    }

    public void SalleProg(SalleProg salleProg) {
        this.salleProg = salleProg;
    }
}
