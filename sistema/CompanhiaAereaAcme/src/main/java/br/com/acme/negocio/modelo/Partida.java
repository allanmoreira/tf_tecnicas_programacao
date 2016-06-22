package br.com.acme.negocio.modelo;

import java.sql.Date;

public class Partida {

	private int idPartida;
	private Date dataPartida;
	private String horaPartida;
	private Aeroporto aeroporto;

	public Partida(int idPartida, Date dataPartida, String horaPartida, Aeroporto aeroporto) {
		this.idPartida = idPartida;
		this.dataPartida = dataPartida;
		this.horaPartida = horaPartida;
		this.aeroporto = aeroporto;
	}

	public int getIdPartida() {
		return idPartida;
	}

	public void setIdPartida(int idPartida) {
		this.idPartida = idPartida;
	}

	public Date getDataPartida() {
		Date data = new Date(dataPartida.getTime());
		return data;
	}

	public void setDataPartida(Date dataPartida) {
		this.dataPartida = dataPartida;
	}

	public String getHoraPartida() {
		return horaPartida;
	}

	public void setHoraPartida(String horaPartida) {
		this.horaPartida = horaPartida;
	}

	public Aeroporto getAeroporto() {
		return aeroporto;
	}

	public void setAeroporto(Aeroporto aeroporto) {
		this.aeroporto = aeroporto;
	}
}
