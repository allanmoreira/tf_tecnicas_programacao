package br.com.acme.exception;

/**
 * Created by allanmoreira on 22/06/16.
 */
public class PromocaoCriterioException extends Exception{
    public PromocaoCriterioException(Throwable cause) {
        super(cause);
    }

    public PromocaoCriterioException(String message, Throwable cause) {
        super(message, cause);
    }

    public PromocaoCriterioException(String message) {
        super(message);
    }

    public PromocaoCriterioException() {
    }
}
