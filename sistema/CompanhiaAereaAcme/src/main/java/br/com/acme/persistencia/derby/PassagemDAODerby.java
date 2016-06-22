package br.com.acme.persistencia.derby;

import br.com.acme.negocio.dao.PassagemDAO;
import br.com.acme.negocio.modelo.Passagem;
import java.util.List;
import br.com.acme.negocio.modelo.Promocao;
import java.math.BigDecimal;

public class PassagemDAODerby implements PassagemDAO {


	/**
	 * @see negocio.dao.PassagemDAO#insert(negocio.modelo.Passagem)
	 */
	public void insert(Passagem passagem) {

	}


	/**
	 * @see negocio.dao.PassagemDAO#update(negocio.modelo.Passagem)
	 */
	public void update(Passagem passagem) {

	}


	/**
	 * @see negocio.dao.PassagemDAO#updatePrecoCompra(negocio.modelo.BigDecimal)
	 * 
	 *  
	 */
	public void updatePrecoCompra(BigDecimal precoCompra) {

	}


	/**
	 * @see negocio.dao.PassagemDAO#updateAssento(int, int)
	 * 
	 *  
	 */
	public void updateAssento(int idPassagem, int idAssento) {

	}


	/**
	 * @see negocio.dao.PassagemDAO#selectById(int)
	 * 
	 *  
	 */
	public Passagem selectById(int idPassagem) {
		return null;
	}


	/**
	 * @see negocio.dao.PassagemDAO#selectAll()
	 */
	public List<Passagem> selectAll() {
		return null;
	}


	/**
	 * @see negocio.dao.PassagemDAO#selectAllByCliente(int)
	 */
	public List<Passagem> selectAllByCliente(int idCliente) {
		return null;
	}


	/**
	 * @see negocio.dao.PassagemDAO#adicionarPromocaoAPassagem(negocio.modelo.Promocao, negocio.modelo.Passagem)
	 * 
	 *  
	 */
	public void adicionarPromocaoAPassagem(Promocao promocao, Passagem passagem) {

	}

}
