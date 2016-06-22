package br.com.acme.negocio.dao;

import br.com.acme.negocio.modelo.Voo;
import java.util.List;

public interface VooDAO {

	public Voo selectById(int idVoo);

	public List<Voo> selectAll();

}
