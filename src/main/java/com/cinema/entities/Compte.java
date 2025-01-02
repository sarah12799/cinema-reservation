package com.cinema.entities;


import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MapsId;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity
@Table(name = "COMPTES")
@NamedQueries({
    @NamedQuery(name = "findAllComptes", query = "SELECT c FROM Compte c"),
    @NamedQuery(name = "findCompteByName", query = "SELECT c FROM Compte c WHERE c.name = :cname"),
    @NamedQuery(name = "findCompteById", query = "SELECT c FROM Compte c WHERE c.id = :cid")
})
public class Compte implements Serializable {
	private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int compte_id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "SOLDE")
    private float solde;
    
    @OneToOne(mappedBy = "compte")
    @MapsId
    private UtilisateurEntity utilisateur;


    public Compte() {
        super();
    }
    public Compte(String nom) {
        this.name=nom;
    }
    public Compte(int id, String name, String password, float solde) {
		super();
		this.compte_id = id;
		this.name = name;
		this.password = password;
		this.solde = solde;
	}

    public int getId() {
        return compte_id;
    }

    public void setId(int id) {
        this.compte_id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public float getSolde() {
        return solde;
    }

    public void setSolde(float solde) {
        this.solde = solde;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Compte[id=").append(getId()).append(", name=").append(getName()).append("]");
        return sb.toString();
    }
    
}
