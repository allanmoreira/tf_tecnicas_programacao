package br.com.acme.negocio.regras;

/**
 * Created by allanmoreira on 22/06/16.
 */
public enum StatusPassagem {
    PENDENTE, UTILIZADA;

    @Override
    public String toString() {
        switch(this) {
            case PENDENTE: return "Pendente";
            case UTILIZADA: return "Utilizada";
            default: throw new NullPointerException();
        }
    }
}
