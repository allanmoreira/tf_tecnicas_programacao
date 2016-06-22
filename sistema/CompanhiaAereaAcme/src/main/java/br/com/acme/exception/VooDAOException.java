package br.com.acme.exception;

public class VooDAOException extends Exception {

    public VooDAOException(String msg) {
        super(msg);
    }

    public VooDAOException(String msg, Throwable causa) {
        super(msg, causa);
    }
}
