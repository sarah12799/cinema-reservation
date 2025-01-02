package com.cinema.service;

import java.util.Set;

import com.cinema.entities.Film;
import com.cinema.entities.SalleProg;
import com.cinema.entities.Seance;
import com.cinema.entities.UtilisateurEntity;
import com.cinema.exception.PlusDePlaceException;
import com.cinema.exception.SoldeInsuffisantException;
import com.cinema.exception.SoldeNegatifException;
import com.cinema.exception.UserNotFoundException;

import jakarta.ejb.Remote;

@Remote
public interface Cinema {
// Lister l'ensemble de films disponible au cinema.
public Set<Film> list ();
// Trouver les films correspondants au pattern donné en entrée.
public Set<Film> findByPattern (String pattern);
// Trouver un film à partir d'un id.
public Film findFilm (int id);
// Réserver une séance pour un utilisateur.
/*public void reserve (Seance seance, Utilisateur u)
throws PlusDePlaceException, SoldeInsuffisantException,
UserNotFoundException, SoldeNegatifException;*/
public Set<SalleProg> getAllSalleProg ();
public Film createFilm (String name);
public void update (Film f);
public float getTarif ();
}
