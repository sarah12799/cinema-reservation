package com.cinema.controller;

import java.io.IOException;
import java.util.Set;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.cinema.entities.Film;
import com.cinema.service.Cinema;

@WebServlet(name = "listFilmsServlet", urlPatterns = {"/listFilms"})
public class ListFilmsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @EJB
    private Cinema cinemaService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = request.getSession().getServletContext();

        // Récupérer la liste de tous les films disponibles à partir du service EJB
        Set<Film> films = cinemaService.list();

        // Ajouter la liste des films aux attributs de la requête
        request.setAttribute("films", films);

        // Forward vers la page JSP pour afficher la liste des films
        context.getRequestDispatcher("/listFilms.jsp").forward(request, response);
    }

    
}
