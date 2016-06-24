package br.com.acme.negocio.regras;

/**
 * Created by allanmoreira on 22/06/16.
 */
public enum StatusPassagem {
    PENDENTE("Pendente"), UTILIZADA("Utilizada");

    public String status;

    StatusPassagem(String valor) {
        status = valor;
    }

    public String getValor() {
        return status;
    }

    @Override
    public String toString() {
        return status;
    }
}
