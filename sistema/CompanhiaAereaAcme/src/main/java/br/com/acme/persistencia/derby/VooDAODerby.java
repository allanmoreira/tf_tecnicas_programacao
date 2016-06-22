package br.com.acme.persistencia.derby;

import br.com.acme.negocio.dao.PassagemDAO;
import br.com.acme.negocio.dao.VooDAO;
import br.com.acme.negocio.modelo.Passagem;
import java.util.List;
import br.com.acme.negocio.modelo.Promocao;
import br.com.acme.negocio.modelo.Voo;

public class VooDAODerby implements VooDAO {

    @Override
    public Voo selectById(int idVoo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Voo> selectAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
