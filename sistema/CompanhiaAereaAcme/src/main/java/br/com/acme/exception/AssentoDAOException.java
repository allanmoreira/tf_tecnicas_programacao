package br.com.acme.exception;

public class AssentoDAOException extends Exception {
    public AssentoDAOException(String msg) {
        super(msg);
    }

    public AssentoDAOException(String msg, Throwable causa) {
        super(msg, causa);
    }
}
