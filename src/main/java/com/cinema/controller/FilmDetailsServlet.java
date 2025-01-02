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

        // Récupérer l'ID du film à partir des paramètres de la requête
        String filmIdParam = request.getParameter("id");
        if (filmIdParam != null && !filmIdParam.isEmpty()) {
            int filmId = Integer.parseInt(filmIdParam);

            // Récupérer les détails du film à partir du service EJB
            Film film = cinemaService.findFilm(filmId);

            if (film != null) {
                // Ajouter le film aux attributs de la requête
                request.setAttribute("film", film);

                // Forward vers la page JSP pour afficher les détails du film
                context.getRequestDispatcher("/filmDetails.jsp").forward(request, response);
            } else {
                // Gérer le cas où le film n'est pas trouvé
                response.sendError(HttpServletResponse.SC_NOT_FOUND, "Film not found");
            }
        } else {
            // Gérer le cas où l'ID du film n'est pas fourni
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Film ID is required");
        }
    }

    
}
