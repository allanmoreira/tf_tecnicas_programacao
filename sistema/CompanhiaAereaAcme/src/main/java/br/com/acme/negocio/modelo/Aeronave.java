package br.com.acme.negocio.modelo;

import java.util.List;

public class Aeronave {

	private String idAeronave;
	private String fabricante;
	private String modelo;
	private int numeroDeAssentos;
	private List<Assento> assento;

	public Aeronave(int numeroDeAssentos, String modelo, String fabricante, String idAeronave) {
		this.numeroDeAssentos = numeroDeAssentos;
		this.modelo = modelo;
		this.fabricante = fabricante;
		this.idAeronave = idAeronave;
	}

	public String getIdAeronave() {
		return idAeronave;
	}

	public void setIdAeronave(String idAeronave) {
		this.idAeronave = idAeronave;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getNumeroDeAssentos() {
		return numeroDeAssentos;
	}

	public void setNumeroDeAssentos(int numeroDeAssentos) {
		this.numeroDeAssentos = numeroDeAssentos;
	}

	public List<Assento> getAssento() {
		return assento;
	}

	public void setAssento(List<Assento> assento) {
		this.assento = assento;
	}
}
