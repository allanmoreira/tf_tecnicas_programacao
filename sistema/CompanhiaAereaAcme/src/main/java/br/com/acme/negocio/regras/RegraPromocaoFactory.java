package br.com.acme.negocio.regras;

public class RegraPromocaoFactory {

	public RegraPromocao createInstance(TipoPromocao tipoPromocao) {
		switch (tipoPromocao) {
			case GRATIS:
				return new PromocaoQtdeVoos();
			case DESCONTO_VALOR_PASSAGEM:
				return new PromocaoDescontoValorPassagem();
		}
		return null;
	}

}
