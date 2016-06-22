package br.com.acme.negocio.dao;

import br.com.acme.negocio.modelo.Assento;

import java.util.List;

public interface AssentoDAO {

	public void selectById(int idAssento);

	public List<Assento> selectAll();

	public List<Assento> selectAll(int idVoo);

}
