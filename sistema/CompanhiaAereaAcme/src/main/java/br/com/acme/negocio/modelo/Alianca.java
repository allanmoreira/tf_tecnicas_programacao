package br.com.acme.negocio.modelo;

public class Alianca {

	private String idAlianca;
	private String nome;

	public Alianca(String idAlianca, String nome) {
		this.idAlianca = idAlianca;
		this.nome = nome;
	}

	public String getIdAlianca() {
		return idAlianca;
	}

	public void setIdAlianca(String idAlianca) {
		this.idAlianca = idAlianca;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
