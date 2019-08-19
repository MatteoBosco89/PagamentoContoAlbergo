package model;

public class FrigoBar {
	
	
	
	public FrigoBar(int codiceFrigoBar, Camera camera) {
		super();
		this.codiceFrigoBar = codiceFrigoBar;
		this.camera = camera;
	}

	public int getCodiceFrigoBar() {
		return codiceFrigoBar;
	}

	public Camera getCamera() {
		return camera;
	}

	public void setCodiceFrigoBar(int codiceFrigoBar) {
		this.codiceFrigoBar = codiceFrigoBar;
	}

	public void setCamera(Camera camera) {
		this.camera = camera;
	}
	
	public String toString() {
		String s = ""+getCodiceFrigoBar();
		return s;
	}
	
	private int codiceFrigoBar;

	private Camera camera;


}
