package br.com.acme.negocio.regras;

import br.com.acme.negocio.modelo.Cliente;

public class IdentificaPassageiroVooNacional implements IdentificaPassageiro {


	/**
	 * @see negocio.regras.IdentificaPassageiro#identificaPassageiro(negocio.modelo.Cliente)
	 */
	public boolean identificaPassageiro(Cliente cliente) {
		return false;
	}

}
