package model;

import java.util.Date;

public class RigaOrdineRistorante {
	
	

	public RigaOrdineRistorante(Pietanza pietanza, Date data, int quantita) {
		super();
		this.pietanza = pietanza;
		this.data = data;
		this.quantita = quantita;
	}

	public Pietanza getPietanza() {
		return pietanza;
	}

	public Date getData() {
		return data;
	}

	public int getQuantita() {
		return quantita;
	}

	public void setPietanza(Pietanza pietanza) {
		this.pietanza = pietanza;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}

	@Override
	public String toString() {
		return "RigaOrdineRistorante [pietanza=" + pietanza + ", data=" + data + ", quantita=" + quantita + "]";
	}

	private Pietanza pietanza;

	private Date data;

	private int quantita;

}
