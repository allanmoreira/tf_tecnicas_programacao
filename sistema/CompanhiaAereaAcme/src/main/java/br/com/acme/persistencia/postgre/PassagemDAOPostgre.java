package br.com.acme.persistencia.postgre;

import br.com.acme.exception.PassagemDAOException;
import br.com.acme.negocio.dao.PassagemDAO;
import br.com.acme.negocio.modelo.Passagem;
import java.util.List;
import br.com.acme.negocio.modelo.Promocao;
import java.math.BigDecimal;

public class PassagemDAOPostgre implements PassagemDAO {

	@Override
	public void insert(Passagem passagem) throws PassagemDAOException {

	}

	@Override
	public void update(Passagem passagem) throws PassagemDAOException {

	}

	@Override
	public void updatePrecoCompra(BigDecimal precoCompra) throws PassagemDAOException {

	}

	@Override
	public void updateAssento(int idPassagem, int idAssento) throws PassagemDAOException {

	}

	@Override
	public Passagem selectById(int idPassagem) throws PassagemDAOException {
		return null;
	}

	@Override
	public List<Passagem> selectAll() throws PassagemDAOException {
		return null;
	}

	@Override
	public List<Passagem> selectAllByCliente(int idCliente) throws PassagemDAOException {
		return null;
	}

	@Override
	public void adicionarPromocaoAPassagem(Promocao promocao, Passagem passagem) throws PassagemDAOException {

	}
}
