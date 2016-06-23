package br.com.acme.negocio.regras;

import br.com.acme.negocio.modelo.Cliente;

public class IdentificaPassageiroVooInternacional implements IdentificaPassageiro {

	public boolean embarqueAutorizado(Cliente cliente) {
		if(cliente.getNumeroPassaporte() != null)
			return true;
		return false;
	}

}
