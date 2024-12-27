package com.cinema.exception;

public class SoldeNegatifException extends Exception {
    public SoldeNegatifException() {
        super("Le solde est devenu négatif après la transaction.");
    }

    public SoldeNegatifException(String message) {
        super(message);
    }
}
