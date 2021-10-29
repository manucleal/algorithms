package uy.edu.ort.obligatorio.mapa;

import uy.edu.ort.obligatorio.ISistema.Estado;

public class Tramo {
	
	private boolean existe;
	
	private double metros;
	
	private Estado estado;
	
	public Tramo () {
		this.estado = Estado.BUENO;
	}

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
		return estado;
	}

	public void setEstados(Estado estados) {
		this.estado = estados;
	}

}
