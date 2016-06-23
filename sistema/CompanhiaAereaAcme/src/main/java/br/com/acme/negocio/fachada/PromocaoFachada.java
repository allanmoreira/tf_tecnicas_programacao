package br.com.acme.negocio.fachada;

import br.com.acme.exception.PromocaoCriterioException;
import br.com.acme.exception.PassagemDAOException;
import br.com.acme.exception.PromocaoDAOException;
import br.com.acme.negocio.dao.PassagemDAO;
import br.com.acme.negocio.modelo.Passagem;
import br.com.acme.negocio.regras.RegraPromocao;
import br.com.acme.negocio.regras.RegraPromocaoFactory;
import br.com.acme.negocio.modelo.Promocao;
import br.com.acme.negocio.dao.PromocaoDAO;
import br.com.acme.persistencia.postgre.PassagemDAOPostgre;
import br.com.acme.persistencia.postgre.PromocaoDAOPostgre;
import org.joda.time.DateTime;
import org.joda.time.Days;

import java.util.List;

public class PromocaoFachada {

	private PromocaoDAO promocaoDAO;
	private PassagemDAO passagemDAO;

	public PromocaoFachada(){
		promocaoDAO = new PromocaoDAOPostgre();
		passagemDAO = new PassagemDAOPostgre();
	}

	public List<Promocao> listaPromocoesDisponiveis() throws PromocaoDAOException {
		return promocaoDAO.selectAll();
	}

	public Promocao buscarPromocao(int idPromocao) throws PromocaoDAOException {
		return promocaoDAO.selectById(idPromocao);
	}

	public void concederPromocao(Promocao promocao, Passagem passagem)
			throws PromocaoCriterioException, PassagemDAOException {
		RegraPromocao regraPromocao;
		regraPromocao = new RegraPromocaoFactory().createInstance(promocao.getTipo());
		boolean passageiroAptoPromocao = regraPromocao.passageiroAptoPromocao(passagem);

		long vencimPromocao = Days.daysBetween(new DateTime(), new DateTime(promocao.getDataValidade())).getDays();

		if (vencimPromocao < 0){
			throw new PromocaoCriterioException("Esta promoção não está mais em vigor!");
		}
		else if(passageiroAptoPromocao){
			regraPromocao.aplicaPromocao(passagem);
			passagemDAO.adicionarPromocaoAPassagem(promocao, passagem);
		}
		else {
			throw new PromocaoCriterioException("O passageiro não se encaixa nos critérios desta promoção!");
		}
	}

}
