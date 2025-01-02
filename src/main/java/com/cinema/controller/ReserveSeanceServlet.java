package com.cinema.controller;

import java.io.IOException;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.cinema.entities.Seance;

import com.cinema.exception.PlusDePlaceException;
import com.cinema.exception.SoldeInsuffisantException;
import com.cinema.exception.SoldeNegatifException;
import com.cinema.exception.UserNotFoundException;
import com.cinema.service.Cinema;

@WebServlet(name = "reserveSeanceServlet", urlPatterns = {"/reserveSeance"})
public class ReserveSeanceServlet extends HttpServlet {
  
}
