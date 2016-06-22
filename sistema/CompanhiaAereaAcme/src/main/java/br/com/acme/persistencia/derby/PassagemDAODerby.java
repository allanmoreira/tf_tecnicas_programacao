package br.com.acme.persistencia.derby;

import br.com.acme.negocio.dao.PassagemDAO;
import br.com.acme.negocio.modelo.Passagem;
import br.com.acme.negocio.modelo.Promocao;

import java.math.BigDecimal;
import java.util.List;

public class PassagemDAODerby implements PassagemDAO {

	public void insert(Passagem passagem) {

	}

	public void update(Passagem passagem) {

	}

	public void updatePrecoCompra(BigDecimal precoCompra) {

	}

	public void updateAssento(int idPassagem, int idAssento) {

	}

	public Passagem selectById(int idPassagem) {
		return null;
	}

	public List<Passagem> selectAll() {
		return null;
	}

	public List<Passagem> selectAllByCliente(int idCliente) {
		return null;
	}

	public void adicionarPromocaoAPassagem(Promocao promocao, Passagem passagem) {

	}

}
