package uy.edu.ort.obligatorio.obrero;

public class NodoObrero {
	
	private Obrero obrero;

	private NodoObrero izquierda;
	private NodoObrero derecha;


	public NodoObrero(Obrero unObrero) {
		this.obrero = unObrero;
	}

	public NodoObrero(Obrero unObrero, NodoObrero izquierda, NodoObrero derecha) {
		this.obrero = unObrero;
		this.izquierda = izquierda;
		this.derecha = derecha;
	}

	public Obrero getDato() {
		return obrero;
	}

	public void setDato(Obrero dato) {
		this.obrero = dato;
	}

	public NodoObrero getIzquierda() {
		return this.izquierda;
	}

	public void setIzquierda(NodoObrero izquierda) {
		this.izquierda = izquierda;
	}
	
	public NodoObrero getDerecha() {
		return derecha;
	}

	public void setDerecha(NodoObrero derecha) {
		this.derecha = derecha;
	}
}
