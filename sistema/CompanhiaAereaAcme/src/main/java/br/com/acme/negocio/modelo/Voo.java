package br.com.acme.negocio.modelo;

public class Voo {

	private int idVoo;
	private int tempoEstimado;
	private Aeronave aeronave;
	private LinhaAerea linhaAerea;
	private Partida partida;
	private Chegada chegada;

	public Voo(int idVoo, int tempoEstimado, Aeronave aeronave, LinhaAerea linhaAerea, Partida partida, Chegada chegada) {
		this.idVoo = idVoo;
		this.tempoEstimado = tempoEstimado;
		this.linhaAerea = linhaAerea;
		this.partida = partida;
		this.chegada = chegada;
	}

	public int getIdVoo() {
		return idVoo;
	}

	public void setIdVoo(int idVoo) {
		this.idVoo = idVoo;
	}

	public int getTempoEstimado() {
		return tempoEstimado;
	}

	public void setTempoEstimado(int tempoEstimado) {
		this.tempoEstimado = tempoEstimado;
	}

	public Aeronave getAeronave() {
		return aeronave;
	}

	public void setAeronave(Aeronave aeronave) {
		this.aeronave = aeronave;
	}

	public LinhaAerea getLinhaAerea() {
		return linhaAerea;
	}

	public void setLinhaAerea(LinhaAerea linhaAerea) {
		this.linhaAerea = linhaAerea;
	}

	public Partida getPartida() {
		return partida;
	}

	public void setPartida(Partida partida) {
		this.partida = partida;
	}

	public Chegada getChegada() {
		return chegada;
	}

	public void setChegada(Chegada chegada) {
		this.chegada = chegada;
	}
}
