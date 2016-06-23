package br.com.acme.exception;

public class AssentoDAOException extends Exception {
    public AssentoDAOException(Throwable cause) {
        super(cause);
    }

    public AssentoDAOException(String message, Throwable cause) {
        super(message, cause);
    }

    public AssentoDAOException(String message) {
        super(message);
    }

    public AssentoDAOException() {
    }
}
