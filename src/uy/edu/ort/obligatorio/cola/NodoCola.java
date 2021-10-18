package Cola;

public class NodoCola<T> {
	private T dato;
	private NodoCola siguiente;
	
	public NodoCola(T dato) {
		this.dato = dato;
	}

	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}

	public NodoCola getSig() {
		return siguiente;
	}

	public void setSig(NodoCola siguiente) {
		this.siguiente = siguiente;
	}
	
}
