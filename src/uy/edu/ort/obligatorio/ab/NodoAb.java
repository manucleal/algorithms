package uy.edu.ort.obligatorio.ab;

public class NodoAb {

	private int dato;

	private NodoAb izquierda;
	
	private NodoAb derecha;


	public NodoAb(int unDato) {
		this.dato = unDato;
	}

	public NodoAb(int unDato, NodoAb izq, NodoAb der) {
		this.dato = unDato;
		this.izquierda = izq;
		this.derecha = der;
	}

	public int getDato() {
		return dato;
	}

	public void setDato(int dato) {
		this.dato = dato;
	}

	public NodoAb getIzquierda() {
		return izquierda;
	}

	public void setIzquierda(NodoAb izquierda) {
		this.izquierda = izquierda;
	}
	
	public NodoAb getDerecha() {
		return derecha;
	}

	public void setDerecha(NodoAb derecha) {
		this.derecha = derecha;
	}
	
}
