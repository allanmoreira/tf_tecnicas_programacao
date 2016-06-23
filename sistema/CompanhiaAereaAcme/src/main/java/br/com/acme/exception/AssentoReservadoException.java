package br.com.acme.exception;

public class AssentoReservadoException extends Exception {
    public AssentoReservadoException(Throwable cause) {
        super(cause);
    }

    public AssentoReservadoException(String message, Throwable cause) {
        super(message, cause);
    }

    public AssentoReservadoException(String message) {
        super(message);
    }

    public AssentoReservadoException() {
    }
}
