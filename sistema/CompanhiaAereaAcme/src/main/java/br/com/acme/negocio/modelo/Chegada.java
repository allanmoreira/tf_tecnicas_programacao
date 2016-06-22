package br.com.acme.negocio.modelo;

import java.sql.Date;

public class Chegada {

	private int idChegada;
	private Date dataChegada;
	private String horaChegada;
	private Aeroporto aeroporto;

	public Chegada(int idChegada, Date dataChegada, String horaChegada, Aeroporto aeroporto) {
		this.idChegada = idChegada;
		this.dataChegada = dataChegada;
		this.horaChegada = horaChegada;
		this.aeroporto = aeroporto;
	}

	public int getIdChegada() {
		return idChegada;
	}

	public void setIdChegada(int idChegada) {
		this.idChegada = idChegada;
	}

	public Date getDataChegada() {
		Date data = new Date(dataChegada.getTime());
		return data;
	}

	public void setDataChegada(Date dataChegada) {
		this.dataChegada = dataChegada;
	}

	public String getHoraChegada() {
		return horaChegada;
	}

	public void setHoraChegada(String horaChegada) {
		this.horaChegada = horaChegada;
	}

	public Aeroporto getAeroporto() {
		return aeroporto;
	}

	public void setAeroporto(Aeroporto aeroporto) {
		this.aeroporto = aeroporto;
	}
}
