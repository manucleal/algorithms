package uy.edu.ort.obligatorio.mapa;

public class Tramo {
	
	private boolean existe;
	
	private double metros;
	
	private Estado estados;
	
	public Tramo () {}

	public boolean isExiste() {
		return existe;
	}

	public void setExiste(boolean existe) {
		this.existe = existe;
	}

	public double getMetros() {
		return metros;
	}

	public void setMetros(double metros) {
		this.metros = metros;
	}

	public Estado getEstados() {
		return estados;
	}

	public void setEstados(Estado estados) {
		this.estados = estados;
	}

}
