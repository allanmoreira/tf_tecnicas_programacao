package br.com.acme.negocio.dao;

import br.com.acme.negocio.modelo.Cliente;

import java.util.List;

public interface ClientDAO {

	public Cliente selectById(int idCliente);

	public Cliente selectByNome(String nome);

	public List<Cliente> selectAll();

}
