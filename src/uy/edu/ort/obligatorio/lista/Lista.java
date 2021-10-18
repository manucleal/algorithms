package uy.edu.ort.obligatorio.lista;

import java.util.Iterator;

public class Lista<T> implements ILista<T> {

	protected NodoLista<T> inicio;
	protected int largo;
	private int tope;

	public Lista() {
		this.inicio = null;
		this.largo = 0;
		this.tope = -1;
	}

	public Lista(int tope) {
		this.inicio = null;
		this.largo = 0;
		this.tope = tope;
	}

	@Override
	public void insertar(T dato) {
		inicio = new NodoLista<T>(dato, inicio);
		largo++;
	}

	@Override
	public void borrar(T dato) {
		if (inicio.getDato().equals(dato)) {
			inicio = inicio.getSig();
			largo--;
		} else {
			NodoLista<T> aux = inicio;
			while (!aux.getSig().getDato().equals(dato)) {
				aux = aux.getSig();
			}
			aux.setSig(aux.getSig().getSig());
			largo--;
		}
	}

	@Override
	public int largo() {
		return largo;
	}

	@Override
	public boolean existe(T dato) {
		NodoLista<T> aux = inicio;
		while (aux != null) {
			if (aux.getDato().equals(dato)) {
				return true;
			}
			aux = aux.getSig();
		}
		return false;
	}

	@Override
	public T recuperar(T dato) {
		NodoLista<T> aux = inicio;
		while (aux != null) {
			if (aux.getDato().equals(dato)) {
				return aux.getDato();
			}
			aux = aux.getSig();
		}
		return null;
	}

	@Override
	public boolean esVacia() {
		return largo == 0;
	}

	@Override
	public boolean esLlena() {
		return tope == largo;
	}

	@Override
	    public Iterator<T> iterator() {
	        return new Iterator<T>() {

	            private NodoLista<T> aux = inicio;

	            @Override
	            public boolean hasNext() {
	                return aux != null;
	            }

	            @Override
	            public T next() {
	                T dato = aux.getDato();
	                aux = aux.getSig();
	                return dato;
	            }

	            @Override
	            public void remove(){
	            }
	            
	        };
	}
	
}
