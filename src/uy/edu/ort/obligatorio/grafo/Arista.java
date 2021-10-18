package uy.edu.ort.obligatorio.grafo;

public class Arista {

	private boolean existe;
	private int peso;
	
	public Arista() {}
	
	public Arista(int unPeso) {
		this.existe = true;
		this.peso = unPeso;
	}
		
	public boolean isExiste() {
		return this.existe;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public void setExiste(boolean existe) {
		this.existe = existe;
	}

}
