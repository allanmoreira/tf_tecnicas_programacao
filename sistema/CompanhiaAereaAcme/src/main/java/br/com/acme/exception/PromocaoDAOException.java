package br.com.acme.exception;

public class PromocaoDAOException extends Exception {
    public PromocaoDAOException(String msg) {
        super(msg);
    }

    public PromocaoDAOException(String msg, Throwable causa) {
        super(msg, causa);
    }
}
