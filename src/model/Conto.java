package model;

public class Conto {
	
	
	
	public Conto(float conto, boolean stato, int idConto) {
		super();
		this.conto = conto;
		this.stato = stato;
		this.idConto = idConto;
	}
	
	
	
	public int getIdConto() {
		return idConto;
	}

	public void setIdConto(int idConto) {
		this.idConto = idConto;
	}

	public boolean getStato() {
		return stato;
	}
	
	public float getConto() {
		return conto;
	}

	public ClienteHotel getCliente() {
		return cliente;
	}
	
	public void setStato(boolean stato) {
		this.stato = stato;
	}

	public void setConto(float conto) {
		this.conto = conto;
	}

	public void setCliente(ClienteHotel cliente) {
		this.cliente = cliente;
	}

	private float conto;
	private int idConto;
	private ClienteHotel cliente;
	private boolean stato;

	public float calcoloTotaleConto(OrdineBibita b, OrdineRistorante r, Soggiorno s) {
		float conto = 0;
		conto += b.calcoloSubOrdineBibita(b.getOrdine());
		conto += r.calcoloSubOrdineRistorante(r.getOrdine());
		conto += s.getSaldo();
		this.setConto(conto);
		return conto;
	}

}
