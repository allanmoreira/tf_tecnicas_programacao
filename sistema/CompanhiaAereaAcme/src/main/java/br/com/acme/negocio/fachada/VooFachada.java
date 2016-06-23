package br.com.acme.negocio.fachada;

import br.com.acme.exception.AssentoDAOException;
import br.com.acme.exception.VooDAOException;
import br.com.acme.negocio.modelo.Assento;
import br.com.acme.negocio.modelo.Voo;
import br.com.acme.negocio.dao.VooDAO;
import br.com.acme.negocio.dao.AssentoDAO;
import br.com.acme.persistencia.postgre.AssentoDAOPostgre;
import br.com.acme.persistencia.postgre.VooDAOPostgre;

import java.util.List;

public class VooFachada {

	private VooDAO vooDAO;
	private AssentoDAO assentoDAO;

	public VooFachada() {
		vooDAO = new VooDAOPostgre();
		assentoDAO = new AssentoDAOPostgre();
	}

	public List<Voo> listaVoosDisponiveis() throws VooDAOException {
		return vooDAO.selectAll();
	}

	public Voo buscarVoo(int idVoo) throws VooDAOException {
		return vooDAO.selectById(idVoo);
	}

	public List<Assento> listaAssentos(Voo voo) throws AssentoDAOException {
		return assentoDAO.selectAll();
	}



}
