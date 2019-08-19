package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Soggiorno {

	private int idRegistrazione;

	public Soggiorno(Date dataInizio, int idRegistrazione, Date dataFine, float saldo,
			Pagamento pagamento, Camera camera, ClienteHotel cliente) {
		super();
		this.dataInizio = dataInizio;
		this.idRegistrazione = idRegistrazione;
		this.dataFine = dataFine;
		this.saldo = saldo;
		this.pagamento = pagamento;
		this.camera = camera;
		this.cliente = cliente;
	}
	
	 
	
	public int getIdCamera() {
		return idCamera;
	}

	public void setIdCamera(int idCamera) {
		this.idCamera = idCamera;
	}

	public int getIdRegistrazione() {
		return idRegistrazione;
	}

	public Date getDataInizio() {
		return dataInizio;
	}

	public Date getDataFine() {
		return dataFine;
	}

	public float getSaldo() {
		return saldo;
	}

	public Pagamento getPagamento() {
		return pagamento;
	}

	public Camera getCamera() {
		return camera;
	}

	public ClienteHotel getCliente() {
		return cliente;
	}

	public void setIdRegistrazione(int idRegistrazione) {
		this.idRegistrazione = idRegistrazione;
	}

	public void setDataInizio(Date dataInizio) {
		this.dataInizio = dataInizio;
	}

	public void setDataFine(Date dataFine) {
		this.dataFine = dataFine;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}

	public void setCamera(Camera camera) {
		this.camera = camera;
	}

	public void setCliente(ClienteHotel cliente) {
		this.cliente = cliente;
	}
	
	public String toString() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		
		String s = (getIdRegistrazione() + " " + getSaldo() + " " + formatter.format(getDataInizio()) + " " + formatter.format(getDataFine()));
		return s;
	}

	private Date dataInizio;
	
	private Date dataFine;

	private float saldo;
	private int idCamera;
	private Pagamento pagamento;

	private Camera camera;

	private ClienteHotel cliente;

}
