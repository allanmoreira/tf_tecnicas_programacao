package br.com.acme.negocio.modelo;

import java.util.Date;
import br.com.acme.negocio.regras.IdentificaPassageiro;
import java.math.BigDecimal;

public class Passagem {

	private int idPassagem;

	private String status;

	private Date dataCompra;

	private BigDecimal precoCompra;

	private Promocao promocao;

	private Cliente cliente;

	private Assento assento;

	private Voo voo;

	private IdentificaPassageiro identificaPassageiro;

	public void setIdPassagem(int idPassagem) {

	}

	public int getIdPassagem() {
		return 0;
	}

	public void setStatus(String status) {

	}

	public String getStatus() {
		return null;
	}

	public void setDataCompra(Date dataCompra) {

	}

	public Date getDataCompra() {
		return null;
	}

	public void setPrecoCompra(BigDecimal precoCompra) {

	}

	public BigDecimal getPrecoCompra() {
		return null;
	}

	public void setCliente(Cliente cliente) {

	}

	public Cliente getCliente() {
		return null;
	}

	public void setPromocao(Promocao promocao) {

	}

	public Promocao getPromocao() {
		return null;
	}

	public void setAssento(Assento assento) {

	}

	public Assento getAssento() {
		return null;
	}

	public void setVoo(Voo voo) {

	}

	public Voo getVoo() {
		return null;
	}

}
