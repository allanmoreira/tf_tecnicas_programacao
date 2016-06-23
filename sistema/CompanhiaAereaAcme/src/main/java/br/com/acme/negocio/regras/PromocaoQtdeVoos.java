package br.com.acme.negocio.regras;

import br.com.acme.exception.PassagemDAOException;
import br.com.acme.negocio.dao.PassagemDAO;
import br.com.acme.negocio.modelo.Passagem;
import br.com.acme.negocio.util.CalculoMonetario;
import br.com.acme.persistencia.postgre.PassagemDAOPostgre;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class PromocaoQtdeVoos implements RegraPromocao {

	/**
	 * Verifica se o passageiro está apto para a promoção.
	 * Se o cliente já adquiriu mais de 5 passagens,
	 * o cliente ganha 10% de desconto no valor total da compra.
	 *
	 * @return
     */
	public boolean passageiroAptoPromocao(Passagem passagem) {
		PassagemDAO passagemDAO = new PassagemDAOPostgre();
		List<Passagem> listaPassagensCliente = null;
		try {
			listaPassagensCliente = passagemDAO.selectAllByCliente(passagem.getCliente().getIdCliente());
		} catch (PassagemDAOException e) {
			// TODO criar arquivo de log
		}

		if(listaPassagensCliente == null || listaPassagensCliente.size() > 5)
			return true;
		return false;
	}

	public void aplicaPromocao(Passagem passagem) {
		BigDecimal valor = passagem.getPrecoCompra();
		valor = new CalculoMonetario().multiplica(valor, new BigDecimal(0.9));
		passagem.setPrecoCompra(valor);
	}

}
