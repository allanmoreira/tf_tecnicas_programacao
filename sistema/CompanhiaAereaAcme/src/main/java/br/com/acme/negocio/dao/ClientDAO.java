package br.com.acme.negocio.dao;

import br.com.acme.exception.ClienteDAOException;
import br.com.acme.negocio.modelo.Cliente;
import java.util.List;

public interface ClientDAO {

	public Cliente selectById(int idCliente) throws ClienteDAOException;

	public Cliente selectByNome(String nome) throws ClienteDAOException;

	public List<Cliente> selectAll() throws ClienteDAOException;

}
