package br.com.acme.negocio.dao;

import br.com.acme.negocio.modelo.Promocao;
import java.util.List;

public interface PromocaoDAO {

	public void insert(Promocao promotion);

	public void update(Promocao promotion);

	public Promocao selectById(int idPromotion);

	public List<Promocao> selectAll();

}
