package com.cinema.exception;

public class SoldeNegatifException extends Exception {
    public SoldeNegatifException() {
        super("Le solde est devenu n�gatif apr�s la transaction.");
    }

    public SoldeNegatifException(String message) {
        super(message);
    }
}
