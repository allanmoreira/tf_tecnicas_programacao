package br.com.acme.persistencia.derby;

import br.com.acme.negocio.modelo.Assento;
import br.com.acme.negocio.dao.AssentoDAO;
import java.util.List;

public class AssentoDAODerby implements AssentoDAO {


	/**
	 * @see negocio.dao.AssentoDAO#selectById(int)
	 * 
	 *  
	 */
	public void selectById(int idAssento) {

	}


	/**
	 * @see negocio.dao.AssentoDAO#selectAll()
	 */
	public List<Assento> selectAll() {
		return null;
	}


	/**
	 * @see negocio.dao.AssentoDAO#selectAll(int)
	 */
	public List<Assento> selectAll(int idVoo) {
		return null;
	}

}
