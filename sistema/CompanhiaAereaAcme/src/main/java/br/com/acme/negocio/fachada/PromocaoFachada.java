package br.com.acme.negocio.fachada;

import br.com.acme.negocio.dao.PassagemDAO;
import br.com.acme.negocio.modelo.Passagem;
import br.com.acme.negocio.regras.RegraPromocaoFactory;
import br.com.acme.negocio.modelo.Promocao;
import br.com.acme.negocio.dao.PromocaoDAO;
import java.util.List;
import java.util.Date;

public class PromocaoFachada {

	public List<Promocao> listaPromocoesDisponiveis() {
		return null;
	}

	public List<Promocao> listaPromocoes(Date de, Date ate) {
		return null;
	}

	public void concederPromocao(Promocao promocao, Passagem passagem) {

	}

}
