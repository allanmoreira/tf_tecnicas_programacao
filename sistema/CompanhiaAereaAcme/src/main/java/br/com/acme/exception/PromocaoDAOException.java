package br.com.acme.exception;

public class PromocaoDAOException extends Exception {
    public PromocaoDAOException(Throwable cause) {
        super(cause);
    }

    public PromocaoDAOException(String message, Throwable cause) {
        super(message, cause);
    }

    public PromocaoDAOException(String message) {
        super(message);
    }

    public PromocaoDAOException() {
    }
}
