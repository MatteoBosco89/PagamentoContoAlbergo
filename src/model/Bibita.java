package model;

public class Bibita {
	
	
	
	public Bibita(int idBibita, float prezzoBibita, String desc) {
		super();
		this.idBibita = idBibita;
		this.prezzoBibita = prezzoBibita;
		this.desc = desc;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public int getIdBibita() {
		return idBibita;
	}

	public float getPrezzoBibita() {
		return prezzoBibita;
	}

	public void setIdBibita(int idBibita) {
		this.idBibita = idBibita;
	}

	public void setPrezzoBibita(float prezzoBibita) {
		this.prezzoBibita = prezzoBibita;
	}

	@Override
	public String toString() {
		return "Bibita [idBibita=" + idBibita + ", desc=" + desc + ", prezzoBibita=" + prezzoBibita + "]";
	}

	private int idBibita;
	private String desc;
	private float prezzoBibita;

}
