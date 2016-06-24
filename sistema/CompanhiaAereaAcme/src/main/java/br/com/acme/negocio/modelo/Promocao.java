package br.com.acme.negocio.modelo;

import br.com.acme.negocio.regras.TipoPromocao;
import java.sql.Date;

public class Promocao {

	private int idPromocao;
	private String descricao;
	private TipoPromocao tipo;
	private Date dataValidade;

	public Promocao(int idPromocao, String descricao, TipoPromocao tipo, Date dataValidade) {
		this.idPromocao = idPromocao;
		this.descricao = descricao;
		this.tipo = tipo;
		this.dataValidade = dataValidade;
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

	public TipoPromocao getTipo() {
		return tipo;
	}

	public void setTipo(TipoPromocao tipo) {
		this.tipo = tipo;
	}

	public Date getDataValidade() {
		Date data = new Date(dataValidade.getTime());
		return data;
	}

	public void setDataValidade(Date dataValidade) {
		this.dataValidade = dataValidade;
	}

}
