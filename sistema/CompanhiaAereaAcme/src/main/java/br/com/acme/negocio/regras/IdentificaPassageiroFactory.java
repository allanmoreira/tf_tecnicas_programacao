package br.com.acme.negocio.regras;

public class IdentificaPassageiroFactory {

	public IdentificaPassageiro createInstance(TipoVoo tipoVoo) {
		switch (tipoVoo) {
			case NACIONAL:
				return new IdentificaPassageiroVooNacional();
			case INTERNACIONAL:
				return new IdentificaPassageiroVooInternacional();
		}
		return null;
	}

}
