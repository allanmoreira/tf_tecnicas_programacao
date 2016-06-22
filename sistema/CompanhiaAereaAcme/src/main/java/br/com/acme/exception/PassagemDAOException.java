package br.com.acme.exception;

public class PassagemDAOException extends Exception {
    public PassagemDAOException(String msg) {
        super(msg);
    }

    public PassagemDAOException(String msg, Throwable causa) {
        super(msg, causa);
    }
}
