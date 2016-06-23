package br.com.acme.persistencia.postgre;

import br.com.acme.exception.VooDAOException;
import br.com.acme.negocio.dao.VooDAO;

import java.util.List;

import br.com.acme.negocio.modelo.Voo;

public class VooDAOPostgre implements VooDAO {

    @Override
    public Voo selectById(int idVoo) throws VooDAOException {
        return null;
    }

    @Override
    public List<Voo> selectAll() throws VooDAOException {
        return null;
    }
}
