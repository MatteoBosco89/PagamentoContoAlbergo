package model;

public class Scontrino {
	
	public Scontrino() {}
	
	
	
	
	public float getSaldoCamera() {
		return saldoCamera;
	}
	public OrdineRistorante getOrdiniRistorante() {
		return ordiniRistorante;
	}
	public OrdineBibita getOrdiniBibite() {
		return ordiniBibite;
	}
	public void setSaldoCamera(float saldoCamera) {
		this.saldoCamera = saldoCamera;
	}
	public void setOrdiniRistorante(OrdineRistorante ordiniRistorante) {
		this.ordiniRistorante = ordiniRistorante;
	}
	public void setOrdiniBibite(OrdineBibita ordiniBibite) {
		this.ordiniBibite = ordiniBibite;
	}




	private float saldoCamera;
	private OrdineRistorante ordiniRistorante;
	private OrdineBibita ordiniBibite;
	
}