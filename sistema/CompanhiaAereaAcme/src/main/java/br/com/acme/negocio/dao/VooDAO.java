package br.com.acme.negocio.dao;

import br.com.acme.exception.VooDAOException;
import br.com.acme.negocio.modelo.Voo;
import java.util.List;

public interface VooDAO {

	public Voo selectById(int idVoo) throws VooDAOException;

	public List<Voo> selectAll() throws VooDAOException;

}
