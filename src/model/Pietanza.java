package model;

public class Pietanza {
	
	
	
	public Pietanza(int idPietanza, float prezzoPietanza, String desc) {
		super();
		this.idPietanza = idPietanza;
		this.prezzoPietanza = prezzoPietanza;
		this.desc = desc;
	}
	
	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public int getIdPietanza() {
		return idPietanza;
	}

	public float getPrezzoPietanza() {
		return prezzoPietanza;
	}

	public void setIdPietanza(int idPietanza) {
		this.idPietanza = idPietanza;
	}

	public void setPrezzoPietanza(float prezzoPietanza) {
		this.prezzoPietanza = prezzoPietanza;
	}

	@Override
	public String toString() {
		return "Pietanza [idPietanza=" + idPietanza + ", desc=" + desc + ", prezzoPietanza=" + prezzoPietanza + "]";
	}

	private int idPietanza;
	private String desc;
	private float prezzoPietanza;

}
