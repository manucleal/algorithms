package uy.edu.ort.obligatorio.cola;

public class Cola<T> {
	private NodoCola<T> inicio;
	private NodoCola<T> fin;
	private int largo;
	
	public Cola() { }
	
	public void encolar(T dato) {
		if (this.inicio == null) {
			inicio = fin = new NodoCola<T>(dato);
		} else {
			fin.setSig(new NodoCola<T>(dato));
			this.fin = fin.getSig();
		}
		largo++;
	}
	
	// Pre: !esVacia()
	public T desencolar() {
		T dato = inicio.getDato();
		inicio = inicio.getSig();
		this.largo--;
		
		return dato;
	}

	public boolean esVacia() {
		return this.largo == 0;
	}
}
