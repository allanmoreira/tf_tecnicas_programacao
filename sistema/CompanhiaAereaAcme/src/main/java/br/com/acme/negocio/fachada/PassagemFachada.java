package br.com.acme.negocio.fachada;

import br.com.acme.exception.*;
import br.com.acme.negocio.dao.AssentoDAO;
import br.com.acme.negocio.dao.PassagemDAO;
import br.com.acme.negocio.dao.VooDAO;
import br.com.acme.negocio.modelo.Assento;
import br.com.acme.negocio.modelo.Passagem;
import br.com.acme.negocio.modelo.Cliente;
import br.com.acme.negocio.dao.ClienteDAO;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;
import br.com.acme.negocio.modelo.Voo;
import br.com.acme.negocio.regras.IdentificaPassageiro;
import br.com.acme.negocio.regras.IdentificaPassageiroFactory;
import br.com.acme.negocio.regras.StatusPassagem;
import br.com.acme.negocio.regras.TipoVoo;
import br.com.acme.negocio.util.ManipulaData;
import br.com.acme.persistencia.postgre.AssentoDAOPostgre;
import br.com.acme.persistencia.postgre.ClienteDAOPostgre;
import br.com.acme.persistencia.postgre.PassagemDAOPostgre;
import br.com.acme.persistencia.postgre.VooDAOPostgre;

public class PassagemFachada {

	private ClienteDAO clienteDAO;
	private VooDAO vooDAO;
	private PassagemDAO passagemDAO;
	private AssentoDAO assentoDAO;

	public PassagemFachada (){
		clienteDAO = new ClienteDAOPostgre();
		vooDAO = new VooDAOPostgre();
		passagemDAO = new PassagemDAOPostgre();
//		assentoDAO = new AssentoDAOPostgre();
	}

	public Cliente buscarCliente(String cpfCliente) throws ClienteDAOException {
		return clienteDAO.selectByCpf(cpfCliente);
	}

	public void cadastrarNovaPassagem
			(int idVoo, String cpfCliente, int reserva, String precoVenda, Date dataCompra, double precoCompra)
			throws ClienteDAOException, VooDAOException, PassagDocumInvalidaException, PassagemDAOException {
		Cliente cliente;
		Voo voo;
		IdentificaPassageiro identificaPassageiro;
		cliente = clienteDAO.selectByCpf(cpfCliente);
		voo = vooDAO.selectById(idVoo);
                
                // TODO Criar regra para saber se um vôo é nacional ou internacional. Não há regra atual
		if(voo.getPartida().getAeroporto().getNome().equals(voo.getChegada().getAeroporto().getNome())) {
			identificaPassageiro = new IdentificaPassageiroFactory().createInstance(TipoVoo.NACIONAL);
		}
		else {
			identificaPassageiro = new IdentificaPassageiroFactory().createInstance(TipoVoo.INTERNACIONAL);
		}

		boolean autorizado = identificaPassageiro.embarqueAutorizado(cliente);

		if(!autorizado) {
			throw new PassagDocumInvalidaException("O cliente não possui a documentação necessária para embarcar nesse vôo!");
		} else {
			Date dataHoje = new ManipulaData().getDataHoje();
			Passagem passagem = new Passagem(StatusPassagem.PENDENTE, dataHoje, new BigDecimal("150"), cliente, voo);
			passagemDAO.insert(passagem);
		}
	}

	public List<Passagem> listaPassagensAdquiridas(int idCliente) throws PassagemDAOException {
		return passagemDAO.selectAllByCliente(idCliente);
	}

	public void reservarAssento(int idAssento, int idPassagem) throws PassagemDAOException, AssentoDAOException, AssentoReservadoException {
		Passagem passagem = passagemDAO.selectById(idPassagem);
		Assento assento = assentoDAO.selectById(idAssento);
		if(assento.isReservado()){
			throw new AssentoReservadoException("Este assento já foi reservado por outro cliente!");
		}
		else {
                    passagem.setAssento(assento);
                    passagemDAO.updateAssento(passagem);
		}
	}
}
