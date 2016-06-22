package br.com.acme.negocio.regras;

import br.com.acme.negocio.modelo.Cliente;

public class ValidaPassageiro {

	public ValidaPassageiro getInstance() {
		return null;
	}

	public boolean validaVooNacional(Cliente cliente) {
		return false;
	}

	public boolean validaVooInternacional(Cliente cliente) {
		return false;
	}

}
