package br.com.acme.negocio.dao;

import br.com.acme.negocio.modelo.Passagem;
import br.com.acme.negocio.modelo.Promocao;

import java.math.BigDecimal;
import java.util.List;

public interface PassagemDAO {

	public void insert(Passagem passagem);

	public void update(Passagem passagem);

	public void updatePrecoCompra(BigDecimal precoCompra);

	public void updateAssento(int idPassagem, int idAssento);

	public Passagem selectById(int idPassagem);

	public List<Passagem> selectAll();

	public List<Passagem> selectAllByCliente(int idCliente);

	public void adicionarPromocaoAPassagem(Promocao promocao, Passagem passagem);

}
