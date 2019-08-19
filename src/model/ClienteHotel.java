package model;

public class ClienteHotel {

	private String nome;

	private String cognome;

	private String codiceFiscale;

	private Soggiorno soggiorno;

	public String getNome() {
		return nome;
	}

	public String getCognome() {
		return cognome;
	}

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public Soggiorno getSoggiorno() {
		return soggiorno;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	public void setSoggiorno(Soggiorno soggiorno) {
		this.soggiorno = soggiorno;
	}
	
	public String toString() {
		String s = (getCodiceFiscale() + " " + getNome() + " " + getCognome());
		return s;
	}

	public ClienteHotel(String nome, String cognome, String codiceFiscale, Soggiorno soggiorno) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.codiceFiscale = codiceFiscale;
		this.soggiorno = soggiorno;
	}

}
