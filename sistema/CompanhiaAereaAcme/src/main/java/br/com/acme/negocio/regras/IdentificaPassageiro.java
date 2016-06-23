package br.com.acme.negocio.regras;

import br.com.acme.negocio.modelo.Cliente;

public interface IdentificaPassageiro {

	public boolean embarqueAutorizado(Cliente cliente);

}
