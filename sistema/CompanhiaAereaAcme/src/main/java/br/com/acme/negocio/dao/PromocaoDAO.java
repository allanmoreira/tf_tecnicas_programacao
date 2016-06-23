package br.com.acme.negocio.dao;

import br.com.acme.exception.PromocaoDAOException;
import br.com.acme.negocio.modelo.Promocao;
import java.util.List;

public interface PromocaoDAO {

	public void insert(Promocao promotion) throws PromocaoDAOException;

	public void update(Promocao promotion) throws PromocaoDAOException;

	public Promocao selectById(int idPromotion) throws PromocaoDAOException;

	public List<Promocao> selectAll() throws PromocaoDAOException;

}
