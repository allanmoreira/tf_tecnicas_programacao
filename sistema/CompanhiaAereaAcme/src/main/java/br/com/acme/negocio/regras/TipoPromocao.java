package br.com.acme.negocio.regras;

public enum TipoPromocao {

	GRATIS, DESCONTO_VALOR_PASSAGEM;

	@Override
	public String toString() {
		switch(this) {
			case GRATIS: return "Passagem Grátis";
			case DESCONTO_VALOR_PASSAGEM: return "Desconto de 50% no valor da passagem";
			default: throw new NullPointerException();
		}
	}

}
