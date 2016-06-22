package br.com.acme.negocio.fachada;


import br.com.acme.negocio.modelo.Cliente;
import br.com.acme.negocio.modelo.Passagem;
import br.com.acme.negocio.modelo.Voo;

import java.util.Date;
import java.util.List;

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
