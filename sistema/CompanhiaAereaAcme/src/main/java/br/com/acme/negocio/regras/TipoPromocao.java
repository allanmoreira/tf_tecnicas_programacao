package br.com.acme.negocio.regras;

public enum TipoPromocao {

    GRATIS("Passagem Grátis"), DESCONTO_VALOR_PASSAGEM("Desconto de 50% no valor da passagem");
        
    public String status;

    TipoPromocao (String valor) {
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
