package br.com.acme.persistencia.postgre;

import br.com.acme.exception.ClienteDAOException;
import br.com.acme.negocio.dao.ClientDAO;
import br.com.acme.negocio.modelo.Cliente;
import java.util.List;

public class ClientDAOPostgre implements ClientDAO {

	@Override
	public Cliente selectById(int idCliente) throws ClienteDAOException {
		return null;
	}

	@Override
	public Cliente selectByNome(String nome) throws ClienteDAOException {
		return null;
	}

	@Override
	public List<Cliente> selectAll() throws ClienteDAOException {
		return null;
	}
}
