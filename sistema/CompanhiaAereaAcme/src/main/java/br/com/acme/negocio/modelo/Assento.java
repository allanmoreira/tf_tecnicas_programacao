package br.com.acme.negocio.modelo;

public class Assento {

	private int idAssento;
	private String tipo;
	private boolean reservado;
	private Aeronave aeronave;

	public Assento(int idAssento, String tipo, boolean reservado, Aeronave aeronave) {
		this.idAssento = idAssento;
		this.tipo = tipo;
		this.reservado = reservado;
		this.aeronave = aeronave;
	}

	public int getIdAssento() {
		return idAssento;
	}

	public void setIdAssento(int idAssento) {
		this.idAssento = idAssento;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public boolean isReservado() {
		return reservado;
	}

	public void setReservado(boolean reservado) {
		this.reservado = reservado;
	}

	public Aeronave getAeronave() {
		return aeronave;
	}

	public void setAeronave(Aeronave aeronave) {
		this.aeronave = aeronave;
	}
}
