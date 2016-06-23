package br.com.acme.exception;

public class PassagemDAOException extends Exception {
    public PassagemDAOException(Throwable cause) {
        super(cause);
    }

    public PassagemDAOException(String message, Throwable cause) {
        super(message, cause);
    }

    public PassagemDAOException(String message) {
        super(message);
    }

    public PassagemDAOException() {
    }
}
