package com.cinema.exception;

public class SoldeInsuffisantException extends Exception {
    public SoldeInsuffisantException() {
        super("Solde insuffisant pour effectuer cette transaction.");
    }

    public SoldeInsuffisantException(String message) {
        super(message);
    }
}
