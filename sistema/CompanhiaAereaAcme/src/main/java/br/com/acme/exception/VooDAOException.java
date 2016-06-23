package br.com.acme.exception;

public class VooDAOException extends Exception {
    public VooDAOException(Throwable cause) {
        super(cause);
    }

    public VooDAOException(String message, Throwable cause) {
        super(message, cause);
    }

    public VooDAOException(String message) {
        super(message);
    }

    public VooDAOException() {
    }
}
