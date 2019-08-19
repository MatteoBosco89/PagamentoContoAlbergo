package model;

public class Pagamento {
	
	
	
	public Pagamento(Conto conto) {
		super();
		this.conto = conto;
	}
	
	
	public Conto getConto() {
		return conto;
	}

	public void setConto(Conto conto) {
		this.conto = conto;
	}

	public float getImportoTotale() {
		return importoTotale;
	}

	public void setImportoTotale(float importoTotale) {
		this.importoTotale = importoTotale;
	}

	private float importoTotale;
	private Conto conto;

}
