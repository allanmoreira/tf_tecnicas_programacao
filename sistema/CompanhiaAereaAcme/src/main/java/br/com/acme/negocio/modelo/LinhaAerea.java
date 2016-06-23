package br.com.acme.negocio.modelo;

public class LinhaAerea {

	private String idLinhaAerea;
	private String nome;
	private Alianca alianca;

	public LinhaAerea(String idLinhaAerea, String nome, Alianca alianca) {
		this.idLinhaAerea = idLinhaAerea;
		this.nome = nome;
		this.alianca = alianca;
	}
        
        public LinhaAerea(String idLinhaAerea, String nome) {
		this.idLinhaAerea = idLinhaAerea;
		this.nome = nome;
		this.alianca = null;
	}

	public String getIdLinhaAerea() {
		return idLinhaAerea;
	}

	public void setIdLinhaAerea(String idLinhaAerea) {
		this.idLinhaAerea = idLinhaAerea;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Alianca getAlianca() {
		return alianca;
	}

	public void setAlianca(Alianca alianca) {
		this.alianca = alianca;
	}
}
