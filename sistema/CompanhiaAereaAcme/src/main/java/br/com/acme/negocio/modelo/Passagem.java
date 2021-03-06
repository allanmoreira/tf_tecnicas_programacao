package br.com.acme.negocio.modelo;

import java.sql.Date;
import br.com.acme.negocio.regras.IdentificaPassageiro;
import br.com.acme.negocio.regras.StatusPassagem;

import java.math.BigDecimal;

public class Passagem {

	private int idPassagem;
	private StatusPassagem status;
	private Date dataCompra;
	private BigDecimal precoCompra;
	private Promocao promocao;
	private Cliente cliente;
	private Assento assento;
	private Voo voo;

	public Passagem(int idPassagem, StatusPassagem status, Date dataCompra, BigDecimal precoCompra, Promocao promocao, Cliente cliente, Assento assento, Voo voo) {
		this.idPassagem = idPassagem;
		this.status = status;
		this.dataCompra = dataCompra;
		this.precoCompra = precoCompra;
		this.promocao = promocao;
		this.cliente = cliente;
		this.assento = assento;
		this.voo = voo;
	}

	public Passagem(StatusPassagem status, Date dataCompra, BigDecimal precoCompra, Cliente cliente, Voo voo) {
		this.status = status;
		this.dataCompra = dataCompra;
		this.precoCompra = precoCompra;
		this.cliente = cliente;
		this.voo = voo;
	}

	public int getIdPassagem() {
		return idPassagem;
	}

	public void setIdPassagem(int idPassagem) {
		this.idPassagem = idPassagem;
	}

	public StatusPassagem getStatus() {
		return status;
	}

	public void setStatus(StatusPassagem status) {
		this.status = status;
	}

	public Date getDataCompra() {
		Date data = new Date(dataCompra.getTime());
		return data;
	}

	public void setDataCompra(Date dataCompra) {
		this.dataCompra = dataCompra;
	}

	public BigDecimal getPrecoCompra() {
		return precoCompra;
	}

	public void setPrecoCompra(BigDecimal precoCompra) {
		this.precoCompra = precoCompra;
	}

	public Promocao getPromocao() {
		return promocao;
	}

	public void setPromocao(Promocao promocao) {
		this.promocao = promocao;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Assento getAssento() {
		return assento;
	}

	public void setAssento(Assento assento) {
		this.assento = assento;
	}

	public Voo getVoo() {
		return voo;
	}

	public void setVoo(Voo voo) {
		this.voo = voo;
	}

    @Override
    public String toString() {
        return "Passagem{" + "idPassagem=" + idPassagem + ", status=" + status + ", dataCompra=" + dataCompra + ", precoCompra=" + precoCompra + ", cliente=" + cliente + '}';
    }

}
