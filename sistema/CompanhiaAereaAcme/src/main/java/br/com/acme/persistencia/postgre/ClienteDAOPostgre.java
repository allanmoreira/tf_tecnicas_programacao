package br.com.acme.persistencia.postgre;

import br.com.acme.exception.ClienteDAOException;
import br.com.acme.negocio.dao.ClienteDAO;
import br.com.acme.negocio.modelo.Cliente;
import java.util.List;

public class ClienteDAOPostgre implements ClienteDAO {

	@Override
	public Cliente selectByCpf(String cpf) throws ClienteDAOException {
		return null;
	}

	@Override
	public List<Cliente> selectAll() throws ClienteDAOException {
		return null;
	}
}
