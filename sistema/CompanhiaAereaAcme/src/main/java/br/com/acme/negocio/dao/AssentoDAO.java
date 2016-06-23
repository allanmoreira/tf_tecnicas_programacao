package br.com.acme.negocio.dao;

import br.com.acme.exception.AssentoDAOException;
import br.com.acme.negocio.modelo.Assento;
import java.util.List;

public interface AssentoDAO {

	public Assento selectById(int idAssento) throws AssentoDAOException;

	public List<Assento> selectAll() throws AssentoDAOException;

	public List<Assento> selectAll(int idVoo) throws AssentoDAOException;

}
