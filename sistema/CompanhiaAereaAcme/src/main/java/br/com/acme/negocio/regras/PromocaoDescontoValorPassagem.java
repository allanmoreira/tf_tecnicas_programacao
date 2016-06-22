package br.com.acme.negocio.regras;

import br.com.acme.negocio.modelo.Passagem;

public class PromocaoDescontoValorPassagem implements RegraPromocao {


	/**
	 * @see negocio.regras.RegraPromocao#passageiroAptoPromocao(negocio.modelo.Passagem)
	 */
	public boolean passageiroAptoPromocao(Passagem passagem) {
		return false;
	}


	/**
	 * @see negocio.regras.RegraPromocao#aplicaPromocao(negocio.modelo.Passagem)
	 * 
	 *  
	 */
	public void aplicaPromocao(Passagem passagem) {

	}

}
