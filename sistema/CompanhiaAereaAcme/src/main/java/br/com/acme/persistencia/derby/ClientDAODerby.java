package br.com.acme.persistencia.derby;

import br.com.acme.negocio.dao.ClientDAO;
import br.com.acme.negocio.modelo.Cliente;
import java.util.List;

public class ClientDAODerby implements ClientDAO {


	/**
	 * @see negocio.dao.ClientDAO#selectById(int)
	 * 
	 *  
	 */
	public Cliente selectById(int idCliente) {
		return null;
	}


	/**
	 * @see negocio.dao.ClientDAO#selectByNome(java.lang.String)
	 */
	public Cliente selectByNome(String nome) {
		return null;
	}


	/**
	 * @see negocio.dao.ClientDAO#selectAll()
	 */
	public List<Cliente> selectAll() {
		return null;
	}

}
