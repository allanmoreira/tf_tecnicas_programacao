package br.com.acme.persistencia.postgre;

import br.com.acme.exception.AssentoDAOException;
import br.com.acme.negocio.modelo.Assento;
import br.com.acme.negocio.dao.AssentoDAO;
import java.util.List;

public class AssentoDAOPostgre implements AssentoDAO {

	@Override
	public Assento selectById(int idAssento) throws AssentoDAOException {
		return null;
	}

	@Override
	public List<Assento> selectAll() throws AssentoDAOException {
		return null;
	}

	@Override
	public List<Assento> selectAll(int idVoo) throws AssentoDAOException {
		return null;
	}
}
