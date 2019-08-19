package model;

import java.util.ArrayList;

public class OrdineRistorante {
	
	public OrdineRistorante(Camera camera) {
		super();
		this.camera = camera;
	}

	public ArrayList<RigaOrdineRistorante> getOrdine() {
		return ordine;
	}

	public Camera getCamera() {
		return camera;
	}

	public void setCamera(Camera camera) {
		this.camera = camera;
	}

	private ArrayList<RigaOrdineRistorante> ordine = new ArrayList<RigaOrdineRistorante>();

	private Camera camera;

	public void creaLista(RigaOrdineRistorante ro) {
		this.ordine.add(ro);
	}
	
	public void stampaLista() {
		for(RigaOrdineRistorante o : ordine) {
			System.out.println(o.toString());
		}
	}

	public float calcoloSubOrdineRistorante(ArrayList<RigaOrdineRistorante> ordine) {
		float sub = 0;
		if(ordine != null && !ordine.isEmpty()) {
			for(RigaOrdineRistorante r : ordine) {
				int q = r.getQuantita();
				float p = r.getPietanza().getPrezzoPietanza();
				sub += (q*p);
			}
		}
		return sub;
	}

}
