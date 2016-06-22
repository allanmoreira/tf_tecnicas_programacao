package br.com.acme.negocio.modelo;

public class Aeroporto {

	private String idAeroporto;
	private String latitude;
	private String longitude;
	private String nome;

    public Aeroporto(String idAeroporto, String latitude, String longitude, String nome) {
        this.idAeroporto = idAeroporto;
        this.latitude = latitude;
        this.longitude = longitude;
        this.nome = nome;
    }

    public String getIdAeroporto() {
		return idAeroporto;
	}

	public void setIdAeroporto(String idAeroporto) {
		this.idAeroporto = idAeroporto;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
