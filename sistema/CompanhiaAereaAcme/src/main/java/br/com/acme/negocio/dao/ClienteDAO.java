package br.com.acme.negocio.dao;

import br.com.acme.exception.ClienteDAOException;
import br.com.acme.negocio.modelo.Cliente;
import java.util.List;

public interface ClienteDAO {

	public Cliente selectByCpf(String cpf) throws ClienteDAOException;

	public List<Cliente> selectAll() throws ClienteDAOException;

}
