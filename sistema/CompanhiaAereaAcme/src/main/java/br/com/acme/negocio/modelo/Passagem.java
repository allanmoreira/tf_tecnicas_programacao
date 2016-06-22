package br.com.acme.negocio.modelo;

import java.math.BigDecimal;
import java.util.Date;

public class Passagem {

	private int idPassagem;

	private Cliente cliente;

	private String status;

	private Date dataCompra;

	private BigDecimal precoCompra;

	private Promocao promocao;

	private int reserva;

	private Assento assento;

	private Voo voo;

	public void setIdPassagem(int idPassagem) {

	}

	public int getIdPassagem() {
		return 0;
	}

	public void setCliente(Cliente cliente) {

	}

	public Cliente getCliente() {
		return null;
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

	public void setPromocao(Promocao promocao) {

	}

	public Promocao getPromocao() {
		return null;
	}

	public void setReserva(int reserva) {

	}

	public int getReserva() {
		return 0;
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
