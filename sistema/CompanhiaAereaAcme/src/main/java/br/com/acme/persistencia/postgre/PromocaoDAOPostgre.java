package br.com.acme.persistencia.postgre;

import br.com.acme.exception.PromocaoDAOException;
import br.com.acme.negocio.dao.PromocaoDAO;
import br.com.acme.negocio.modelo.Promocao;
import java.util.List;

public class PromocaoDAOPostgre implements PromocaoDAO {

	@Override
	public Promocao selectById(int idPromotion) throws PromocaoDAOException {
		return null;
	}

	@Override
	public List<Promocao> selectAll() throws PromocaoDAOException {
		return null;
	}
}
