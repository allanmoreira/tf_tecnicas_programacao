package br.com.acme.negocio.modelo;

public class Cliente {

	private int idCliente;
	private String nome;
	private String rg;
	private String cpf;
	private String numeroPassaporte;

	public Cliente(int idCliente, String nome, String rg, String cpf, String numeroPassaporte) {
		this.idCliente = idCliente;
		this.nome = nome;
		this.rg = rg;
		this.cpf = cpf;
		this.numeroPassaporte = numeroPassaporte;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNumeroPassaporte() {
		return numeroPassaporte;
	}

	public void setNumeroPassaporte(String numeroPassaporte) {
		this.numeroPassaporte = numeroPassaporte;
	}

    @Override
    public String toString() {
        return "Cliente{" + "idCliente=" + idCliente + ", nome=" + nome + ", rg=" + rg + ", cpf=" + cpf + ", numeroPassaporte=" + numeroPassaporte + '}';
    }
        
        
}
