package com.cinema.controller;

import java.io.IOException;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.cinema.entities.Film;
import com.cinema.service.Cinema;

@WebServlet(name = "filmDetailsServlet", urlPatterns = {"/filmDetails"})
public class FilmDetailsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @EJB
    private Cinema cinemaService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = request.getSession().getServletContext();

        // R�cup�rer l'ID du film � partir des param�tres de la requ�te
        String filmIdParam = request.getParameter("id");
        if (filmIdParam != null && !filmIdParam.isEmpty()) {
            int filmId = Integer.parseInt(filmIdParam);

            // R�cup�rer les d�tails du film � partir du service EJB
            Film film = cinemaService.findFilm(filmId);

            if (film != null) {
                // Ajouter le film aux attributs de la requ�te
                request.setAttribute("film", film);

                // Forward vers la page JSP pour afficher les d�tails du film
                context.getRequestDispatcher("/filmDetails.jsp").forward(request, response);
            } else {
                // G�rer le cas o� le film n'est pas trouv�
                response.sendError(HttpServletResponse.SC_NOT_FOUND, "Film not found");
            }
        } else {
            // G�rer le cas o� l'ID du film n'est pas fourni
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Film ID is required");
        }
    }

    
}
