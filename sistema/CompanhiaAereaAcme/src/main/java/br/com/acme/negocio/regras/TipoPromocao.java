package br.com.acme.negocio.regras;

public enum TipoPromocao {

	QTDE_VOOS, DESCONTO_VALOR_PASSAGEM;

	@Override
	public String toString() {
		switch(this) {
			case QTDE_VOOS: return "Quantidade de passagens já adquiridas";
			case DESCONTO_VALOR_PASSAGEM: return "Desconto de 50% no valor da passagem";
			default: throw new NullPointerException();
		}
	}

}
