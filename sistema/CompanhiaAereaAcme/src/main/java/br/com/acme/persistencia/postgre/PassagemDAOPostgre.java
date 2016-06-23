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

	/**
	 * Adiciona o assento escolhido à passagem
	 *
	 * @param idPassagem
	 * @param idAssento
	 * @throws PassagemDAOException
     */
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

	/**
	 * Cumpre pedido do enunciado, que pede a tela de consulta das passagens.
	 *
	 * @param idCliente
	 * @return
	 * @throws PassagemDAOException
     */
	@Override
	public List<Passagem> selectAllByCliente(int idCliente) throws PassagemDAOException {
		return null;
	}

	/**
	 * Adiciona a chave estrangeira da promoção na passagem e altera o valor da passagem.
	 *
	 * @param promocao
	 * @param passagem
	 * @throws PassagemDAOException
     */
	@Override
	public void adicionarPromocaoAPassagem(Promocao promocao, Passagem passagem) throws PassagemDAOException {

	}
}
