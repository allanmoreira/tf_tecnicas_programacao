package br.com.acme.exception;

public class ClienteDAOException extends Exception {
    public ClienteDAOException(String msg) {
        super(msg);
    }

    public ClienteDAOException(String msg, Throwable causa) {
        super(msg, causa);
    }
}
