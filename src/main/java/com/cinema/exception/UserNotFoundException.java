package com.cinema.exception;

public class UserNotFoundException extends Exception {
    public UserNotFoundException() {
        super("Utilisateur non trouv�.");
    }

    public UserNotFoundException(String message) {
        super(message);
    }
}
