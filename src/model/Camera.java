package model;

public class Camera {
	
	
	
	public Camera(int numeroCamera, String stato, String tipo, float costoNotte, FrigoBar frigo) {
		super();
		this.numeroCamera = numeroCamera;
		this.stato = stato;
		this.tipo = tipo;
		this.costoNotte = costoNotte;
		this.frigo = frigo;
		this.consumiFrigoBarGiornalieri = null;
		this.consumiRistoranteGiornalieri = null;

	}

	public int getNumeroCamera() {
		return numeroCamera;
	}

	public String getStato() {
		return stato;
	}

	public String getTipo() {
		return tipo;
	}

	public float getCostoNotte() {
		return costoNotte;
	}

	public FrigoBar getFrigo() {
		return frigo;
	}

	public OrdineBibita getConsumiFrigoBarGiornalieri() {
		return consumiFrigoBarGiornalieri;
	}

	public OrdineRistorante getConsumiRistoranteGiornalieri() {
		return consumiRistoranteGiornalieri;
	}

	public void setNumeroCamera(int numeroCamera) {
		this.numeroCamera = numeroCamera;
	}

	public void setStato(String stato) {
		this.stato = stato;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public void setCostoNotte(float costoNotte) {
		this.costoNotte = costoNotte;
	}

	public void setFrigo(FrigoBar frigo) {
		this.frigo = frigo;
	}

	public void setConsumiFrigoBarGiornalieri(OrdineBibita consumiFrigoBarGiornalieri) {
		this.consumiFrigoBarGiornalieri = consumiFrigoBarGiornalieri;
	}

	public void setConsumiRistoranteGiornalieri(OrdineRistorante consumiRistoranteGiornalieri) {
		this.consumiRistoranteGiornalieri = consumiRistoranteGiornalieri;
	}
	
	
	
	@Override
	public String toString() {
		return "Camera [numeroCamera=" + numeroCamera + ", stato=" + stato + ", tipo=" + tipo + ", costoNotte="
				+ costoNotte + ", frigo=" + frigo + ", consumiFrigoBarGiornalieri=" + consumiFrigoBarGiornalieri
				+ ", consumiRistoranteGiornalieri=" + consumiRistoranteGiornalieri + "]";
	}



	private int numeroCamera;

	private String stato;

	private String tipo;

	private float costoNotte;

	private FrigoBar frigo;

	private OrdineBibita consumiFrigoBarGiornalieri;

	private OrdineRistorante consumiRistoranteGiornalieri;

}
