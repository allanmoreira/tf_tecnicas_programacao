package br.com.acme.negocio.regras;

import br.com.acme.negocio.modelo.Cliente;

public class IdentificaPassageiroVooNacional implements IdentificaPassageiro {

	public boolean embarqueAutorizado(Cliente cliente) {
		if(cliente.getCpf() != null || cliente.getRg() != null || cliente.getNumeroPassaporte() != null)
			return true;
		return false;
	}

}
