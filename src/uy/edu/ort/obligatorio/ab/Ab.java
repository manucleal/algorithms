package uy.edu.ort.obligatorio.ab;

import uy.edu.ort.obligatorio.ab.Ab;

public class Ab {
	
	private NodoAb raiz;

	public NodoAb getRaiz() {
		return raiz;
	}

	public Ab(NodoAb unaRaiz) {
		this.raiz = unaRaiz; 
	}

	public Ab() {}

	public int cantidadNodos() {
		return cantidadNodos(this.raiz);
	}

	private int cantidadNodos(NodoAb raiz) {
		if (raiz == null)
			return 0;

		return 1 + cantidadNodos(raiz.getIzquierda()) + cantidadNodos(raiz.getDerecha());
	}

	public int cantidadHojas() {
		return cantidadHojas(this.raiz);
	}

	private int cantidadHojas(NodoAb raiz) {
		if (raiz == null)
			return 0;

		if (raiz.getIzquierda() == null && raiz.getDerecha() == null)
			return 1;

		return cantidadHojas(raiz.getIzquierda()) + cantidadHojas(raiz.getDerecha());
	}

	public int peso() {
		return (this.raiz == null) ? 0 : cantidadNodos(this.raiz) - 1;
	}

	public int altura() {
		return altura(this.raiz);
	}

	private int altura(NodoAb raiz) {
		if (raiz == null)
			return -1;

		return 1 + Math.max(altura(raiz.getIzquierda()), altura(raiz.getDerecha()));
	}

	public boolean todosPares() {
		return todosPares(this.raiz);
	}

	private boolean todosPares(NodoAb raiz) {
		if (raiz == null)
			return true;

		return (raiz.getDato() % 2 == 0)
				&& todosPares(raiz.getIzquierda())
				&& todosPares(raiz.getDerecha());
	}

	public boolean iguales(Ab Ab1, Ab Ab2) {
		return iguales(Ab1.raiz, Ab2.raiz);
	}

	private boolean iguales(NodoAb raiz1, NodoAb raiz2) {
		if (raiz1 == null && raiz2 == null)
			return true;
		if (raiz1 == null || raiz2 == null)
			return false;
		if (raiz1.getDato() != raiz2.getDato())
			return false;

		return iguales(raiz1.getIzquierda(), raiz2.getIzquierda())
				&& iguales(raiz1.getDerecha(), raiz2.getDerecha());
	}

	public Ab clon() {
		return clon(raiz);
	}
	
	private Ab clon(NodoAb raiz) {
		if (raiz == null) return new Ab();
		
		return new Ab(
				new NodoAb(raiz.getDato(), 
						clon(raiz.getIzquierda()).getRaiz(), 
						clon(raiz.getDerecha()).getRaiz()
				));
	}
	
	public Ab espejo() {
		return espejo(raiz);
	}
	
	private Ab espejo(NodoAb a) {
		if (raiz == null) return new Ab();
		
		return new Ab(
				new NodoAb(raiz.getDato(), 
						clon(raiz.getDerecha()).getRaiz(), 
						clon(raiz.getIzquierda()).getRaiz()
				 ));
	}
	
	public boolean equilibrado() {
		return equilibrado(raiz);
	}
	
	private boolean equilibrado(NodoAb nodo) {
		if (nodo == null) return true;
		
		return Math.abs(altura(nodo.getIzquierda()) - altura(nodo.getDerecha())) <= 1
			&& equilibrado(nodo.getDerecha()) && equilibrado(nodo.getIzquierda());
	}
	
	public boolean pertenece(int dato) {
		return pertenece(raiz, dato);
	}
	
	private boolean pertenece(NodoAb nodo, int dato) {
		if (nodo == null) return false;
		
		if (nodo.getDato() == dato) return true;
		
		return pertenece(nodo.getIzquierda(), dato) || pertenece(nodo.getDerecha(), dato);
	}
}
