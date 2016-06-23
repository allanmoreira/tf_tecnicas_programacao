package br.com.acme.exception;

/**
 * Created by allanmoreira on 22/06/16.
 */
public class PassagDocumInvalidaException extends Exception{
    public PassagDocumInvalidaException(Throwable cause) {
        super(cause);
    }

    public PassagDocumInvalidaException(String message, Throwable cause) {
        super(message, cause);
    }

    public PassagDocumInvalidaException(String message) {
        super(message);
    }

    public PassagDocumInvalidaException() {
    }
}
