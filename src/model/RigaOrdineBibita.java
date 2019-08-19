package model;

import java.util.Date;

public class RigaOrdineBibita {
	
	
	
	public RigaOrdineBibita(Bibita bibita, Date data, int quantita) {
		super();
		this.bibita = bibita;
		this.data = data;
		this.quantita = quantita;
	}

	public Bibita getBibita() {
		return bibita;
	}

	public Date getData() {
		return data;
	}

	public int getQuantita() {
		return quantita;
	}

	public void setBibita(Bibita bibita) {
		this.bibita = bibita;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}

	@Override
	public String toString() {
		return "RigaOrdineBibita [bibita=" + bibita + ", data=" + data + ", quantita=" + quantita + "]";
	}

	private Bibita bibita;

	private Date data;

	private int quantita;

}
