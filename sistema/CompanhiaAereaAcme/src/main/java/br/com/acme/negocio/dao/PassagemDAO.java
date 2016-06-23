package br.com.acme.negocio.dao;

import br.com.acme.exception.PassagemDAOException;
import br.com.acme.negocio.modelo.Passagem;
import java.util.List;
import br.com.acme.negocio.modelo.Promocao;
import java.math.BigDecimal;

public interface PassagemDAO {

	public void insert(Passagem passagem) throws PassagemDAOException;

	public void updateAssento(int idPassagem, int idAssento) throws PassagemDAOException;

	public Passagem selectById(int idPassagem) throws PassagemDAOException;

	public List<Passagem> selectAll() throws PassagemDAOException;

	public List<Passagem> selectAllByCliente(int idCliente) throws PassagemDAOException;

	public void adicionarPromocaoAPassagem(Promocao promocao, Passagem passagem) throws PassagemDAOException;

}
