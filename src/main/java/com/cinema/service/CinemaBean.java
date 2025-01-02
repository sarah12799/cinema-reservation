package com.cinema.service;



import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.cinema.entities.Film;
import com.cinema.entities.SalleProg;
import com.cinema.entities.Seance;
import com.cinema.entities.UtilisateurEntity;
import com.cinema.service.Utilisateur;
import com.cinema.exception.PlusDePlaceException;
import com.cinema.exception.SoldeInsuffisantException;
import com.cinema.exception.SoldeNegatifException;
import com.cinema.exception.UserNotFoundException;
import com.cinema.service.Cinema;

import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import jakarta.ejb.TransactionAttribute;
import jakarta.ejb.TransactionAttributeType;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class CinemaBean implements Cinema {

    @PersistenceContext
    private EntityManager em;
    @EJB
    private Utilisateur utilisateurService;

    @Override
    public Set<Film> list() {
        Query q = em.createQuery("SELECT f FROM Film f", Film.class);
        List<Film> films = q.getResultList();
        return films.stream().collect(Collectors.toSet());
    }

    @Override
    public Set<Film> findByPattern(String pattern) {
        Query q = em.createQuery("SELECT f FROM Film f WHERE f.nom LIKE :pattern", Film.class);
        q.setParameter("pattern", "%" + pattern + "%");
        List<Film> films = q.getResultList();
        return films.stream().collect(Collectors.toSet());
    }

    @Override
    public Film findFilm(int id) {
        return em.find(Film.class, id);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    @Override
    public void reserve(Seance seance, UtilisateurEntity utilisateur) throws PlusDePlaceException, SoldeInsuffisantException, UserNotFoundException, SoldeNegatifException {
        // Authentifier l'utilisateur
        try {
            utilisateurService.init(utilisateur.getName(), utilisateur.getCompte().getPassword());
        } catch (UserNotFoundException e) {
            throw new UserNotFoundException("Utilisateur non trouv� ou informations d'identification incorrectes.");
        }

        // V�rifier si la s�ance a encore des places disponibles
        if (seance.getPlaces() <= 0) {
            throw new PlusDePlaceException();
        }

        // V�rifier si l'utilisateur a un solde suffisant
        float tarif = seance.getTarif();
        float soldeUtilisateur = utilisateur.getCompte().getSolde();
        if (soldeUtilisateur < tarif) {
            throw new SoldeInsuffisantException();
        }
        try {
            utilisateurService.debite(tarif);
        } catch (SoldeNegatifException e) {
            throw new SoldeNegatifException("Solde insuffisant pour effectuer cette r�servation.");
        }

        // R�server la s�ance
        seance.setPlaces(seance.getPlaces() - 1);
        em.merge(seance);
        }
    @Override
    public Set<SalleProg> getAllSalleProg() {
        Query q = em.createQuery("SELECT sp FROM SalleProg sp", SalleProg.class);
        List<SalleProg> salleProgs = q.getResultList();
        return salleProgs.stream().collect(Collectors.toSet());
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    @Override
    public Film createFilm(String name) {
        Film film = new Film();
        film.setNom(name);
        em.persist(film);
        return film;
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    @Override
    public void update(Film film) {
        em.merge(film);
    }

    @Override
    public float getTarif() {
        return 10.0f; // Valeur par d�faut
    }
}

