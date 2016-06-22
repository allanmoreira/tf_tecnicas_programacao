package br.com.acme.negocio.modelo;

import java.sql.Date;
import br.com.acme.negocio.regras.RegraPromocao;

public class Promocao {

	private int idPromocao;
	private String descricao;
	private String tipo;
	private Date dataValidade;
	private RegraPromocao regraPromocao;

	public Promocao(int idPromocao, String descricao, String tipo, Date dataValidade, RegraPromocao regraPromocao) {
		this.idPromocao = idPromocao;
		this.descricao = descricao;
		this.tipo = tipo;
		this.dataValidade = dataValidade;
		this.regraPromocao = regraPromocao;
	}

	public int getIdPromocao() {
		return idPromocao;
	}

	public void setIdPromocao(int idPromocao) {
		this.idPromocao = idPromocao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Date getDataValidade() {
		Date data = new Date(dataValidade.getTime());
		return data;
	}

	public void setDataValidade(Date dataValidade) {
		this.dataValidade = dataValidade;
	}

	public RegraPromocao getRegraPromocao() {
		return regraPromocao;
	}

	public void setRegraPromocao(RegraPromocao regraPromocao) {
		this.regraPromocao = regraPromocao;
	}
}
