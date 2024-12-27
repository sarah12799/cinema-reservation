package com.cinema.exception;



public class PlusDePlaceException extends Exception {
    public PlusDePlaceException() {
        super("Il n'y a plus de places disponibles pour cette s�ance.");
    }

    public PlusDePlaceException(String message) {
        super(message);
    }
}
