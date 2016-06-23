package br.com.acme.exception;

public class ClienteDAOException extends Exception {
    public ClienteDAOException(Throwable cause) {
        super(cause);
    }

    public ClienteDAOException(String message, Throwable cause) {
        super(message, cause);
    }

    public ClienteDAOException(String message) {
        super(message);
    }

    public ClienteDAOException() {
    }
}
