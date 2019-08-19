package model;

import java.util.ArrayList;

public class OrdineBibita {
	
	
	
	public OrdineBibita(Camera camera) {
		super();
		this.camera = camera;
	}

	public ArrayList<RigaOrdineBibita> getOrdine() {
		return ordine;
	}

	public Camera getCamera() {
		return camera;
	}

	public void setOrdine(ArrayList<RigaOrdineBibita> ordine) {
		this.ordine = ordine;
	}

	public void setCamera(Camera camera) {
		this.camera = camera;
	}

	private ArrayList<RigaOrdineBibita> ordine = new ArrayList<RigaOrdineBibita>();

	private Camera camera;

	public void creaLista(RigaOrdineBibita ro) {
		this.ordine.add(ro);
	}
	
	public void stampaLista() {
		for(RigaOrdineBibita o : ordine) {
			System.out.println(o.toString());
		}
	}

	public float calcoloSubOrdineBibita(ArrayList<RigaOrdineBibita> ordine) {
		float sub = 0;
		if(ordine != null && !ordine.isEmpty()) {
			for(RigaOrdineBibita r : ordine) {
				int q = r.getQuantita();
				float p = r.getBibita().getPrezzoBibita();
				sub += (q*p);
			}
		}
		return sub;		
	}

}
