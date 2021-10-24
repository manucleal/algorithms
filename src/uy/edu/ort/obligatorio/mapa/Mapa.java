package uy.edu.ort.obligatorio.mapa;

public class Mapa {
	
	private int tope;
	
	private int cantidad;
	
	private Poste[] postes;
	
	private Tramo[][] tramos;
	
	public Mapa() {}
	
	
	public Mapa(int unTope) {
		this.tope = unTope;
		this.inicializarPostes();
		this.tramos = new Tramo[this.tope][this.tope];
		for (int i = 0; i < this.tope; i++) {
			for (int j = 0; j < this.tope; j++) {
				this.tramos[i][j] = new Tramo();
			}
		}
	}
	
	private void inicializarPostes() {
		this.setPostes(new Poste[this.tope]);
		for(int i = 0; i < this.tope; i++) {
			this.postes[i] = new Poste();
		}
	}
	
	public Mapa(int unTope, boolean esDirigido) {
		this.tope = unTope;
		this.setPostes(new Poste[tope]);
		this.tramos = new Tramo[tope][tope];
		if (esDirigido) {
			for (int i = 0; i < tope; i++) {
				for (int j = 0; j < tope; j++) {
					this.tramos[i][j] = new Tramo();
				}
			}
		} else {
			for (int i = 0; i < tope; i++) {
				for (int j = i; j < tope; j++) {
					this.tramos[i][j] = new Tramo();
					this.tramos[j][i] = this.tramos[i][j];
				}
			}
		}
	}

	public void setPostes(Poste[] postes) {
		this.postes = postes;
	}
	
	public boolean existePoste(double coordX, double coordY, String nombre) {
		return this.obtenerPosPoste(coordX, coordY, nombre) != -1;
	}
	
	public int obtenerPosPoste(double coordX, double coordY, String nombre) {
		Poste auxPoste = new Poste(coordX, coordY, nombre);
		for (int i = 0; i < this.postes.length; i++) {
			if (postes[i].equals(auxPoste)) {
				return i;
			}
		}
		return -1;
	}
	
	//PRE: !esLleno()
	private int obtenerPosPosteLibre() {
		for (int i = 0; i < this.tope; i++) {
			if (!postes[i].isExiste()) return i;
		}
		return -1;
	}
	
	//PRE: !esLleno && !existeVertice
	public void agregarPoste(double coordX, double coordY, String nombre) {
	    int pos = obtenerPosPosteLibre();
		this.postes[pos] = new Poste(coordX, coordY, nombre);
		this.cantidad++;
	}
	
	//PRE: existeVertice(Origen) && existeVertice(destino)
	//public boolean existeTramo(double coordXorigen, double coordYorigen, double coordXdestino, double coordYdestino) {
		//int posOrigen = obtenerPosPoste(coordXorigen, coordYorigen);
		//int posDestino = obtenerPosPoste(coordXdestino, coordYdestino);
		//return this.tramos[posOrigen][posDestino].isExiste();
	//}
	
	//PRE: existeVertice(Origen) && existeVertice(destino) && !existeArista
//	public void agregarTramo(String origen, String destino, double metros) {
//		int posOrigen = obtenerPosPoste(origen);
//		int posDestino = obtenerPosPoste(destino);
//		
//		Tramo t = this.tramos[posOrigen][posDestino];
//		t.setExiste(true);
//		t.setMetros(metros);
//	}
	
	public boolean esLleno() {
		return this.cantidad == this.tope;
	}
	
	public boolean esVacio() {
		return this.cantidad == 0;
	}

}
