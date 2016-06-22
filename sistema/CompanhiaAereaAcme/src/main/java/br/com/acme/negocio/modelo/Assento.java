package br.com.acme.negocio.modelo;

public class Assento {

	private int idAssento;
	private char tipo;
	private boolean reservado;
	private Aeronave aeronave;

	public Assento(int idAssento, char tipo, boolean reservado, Aeronave aeronave) {
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

	public char getTipo() {
		return tipo;
	}

	public void setTipo(char tipo) {
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
