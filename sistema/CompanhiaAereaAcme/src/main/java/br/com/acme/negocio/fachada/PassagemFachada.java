package br.com.acme.negocio.fachada;

import br.com.acme.negocio.dao.PassagemDAO;
import br.com.acme.negocio.modelo.Promocao;
import br.com.acme.negocio.modelo.Passagem;
import br.com.acme.negocio.modelo.Cliente;
import br.com.acme.negocio.dao.ClientDAO;
import br.com.acme.negocio.dao.AssentoDAO;
import br.com.acme.negocio.modelo.Assento;
import br.com.acme.negocio.regras.IdentificaPassageiroFactory;
import java.util.Date;
import java.util.List;
import br.com.acme.negocio.modelo.Voo;

public class PassagemFachada {

	public void cadastrarNovaPassagem(Cliente client, int reserva, String precoVenda, Date dataCompra, double precoCompra) {

	}

	public List<Passagem> listaPassagensAdquiridas(int idCliente) {
		return null;
	}

	public List<Voo> listaAssentos(Voo voo) {
		return null;
	}

	public void reservarAssento() {

	}

}
