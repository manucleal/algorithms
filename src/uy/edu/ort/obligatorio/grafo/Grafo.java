package uy.edu.ort.obligatorio.grafo;

import uy.edu.ort.obligatorio.cola.*;
import uy.edu.ort.obligatorio.lista.*;

public class Grafo {
	private int tope;
	private int cantidad; 
	private String[] vertices;
	private Arista[][] matAdy;
		// Fila: Arista entrante.
		// Columna: Arista saliente.
	
	public Grafo(int unTope) {
		this.tope = unTope;
		this.vertices = new String[tope];
		this.matAdy = new Arista[tope][tope];
		for (int i = 0; i < tope; i++) {
			for (int j = 0; j < tope; j++) {
				this.matAdy[i][j] = new Arista();
			}
		}
	}
	
	public Grafo(int unTope, boolean esDirigido) {
		this.tope = unTope;
		this.vertices = new String[tope];
		this.matAdy = new Arista[tope][tope];
		if (esDirigido) {
			for (int i = 0; i < tope; i++) {
				for (int j = 0; j < tope; j++) {
					this.matAdy[i][j] = new Arista();
				}
			}
		} else {
			for (int i = 0; i < tope; i++) {
				for (int j = i; j < tope; j++) {
					this.matAdy[i][j] = new Arista();
					this.matAdy[j][i] = this.matAdy[i][j];
				}
			}
		}
	}
	
	public boolean esLleno() {
		return this.cantidad == this.tope;
	}
	
	public boolean esVacio() {
		return this.cantidad == 0;
	}
	
	//PRE: !esLleno()
	private int obtenerPosLibre() {
		for (int i = 0; i < this.tope; i++) {
			if (vertices[i] == null) return i;
		}
		return -1;
	}

	public int obtenerPos(String vert) {
		for (int i = 0; i < vertices.length; i++) {
			if (vertices[i].equals(vert)) return i;
		}
		return -1;
	}
	
	//PRE: !esLleno && !existeVertice
	public void agregarVertice(String vert) {
		this.vertices[obtenerPosLibre()] = vert;
		this.cantidad++;
	}
	
	//PRE: existeVertice
	public void borrarVertice(String vert) {
		int posBorrar = obtenerPos(vert);
		// Primero, borro vertice.
		this.vertices[posBorrar] = null;
		this.cantidad--;
		// Despues, elimino sus aristas.
		for (int i = 0; i < tope; i++) {
			this.matAdy[posBorrar][i].setExiste(false); // Borra fila.
			this.matAdy[i][posBorrar].setExiste(false); // Borra columna.
		}
	}

	public boolean existeVertice(String vert) {
		return obtenerPos(vert) != -1;
	}
	
	//PRE: existeVertice(Origen) && existeVertice(destino) && !existeArista
	public void agregarArista(String origen, String destino, int peso) {
		int posOrigen = obtenerPos(origen);
		int posDestino = obtenerPos(destino);
		
		Arista a = this.matAdy[posOrigen][posDestino];
		a.setExiste(true);
		a.setPeso(peso);
	}

	//PRE: existeVertice(Origen) && existeVertice(destino)
	public boolean existeArista(String origen, String destino, int peso) {
		int posOrigen = obtenerPos(origen);
		int posDestino = obtenerPos(destino);
		return this.matAdy[posOrigen][posDestino].isExiste();
	}
	
	//PRE: existeVertice(Origen) && existeVertice(destino) && existeArista
	public void borrarArista(String origen, String destino) {
		int posOrigen = obtenerPos(origen);
		int posDestino = obtenerPos(destino);
		
		Arista a = this.matAdy[posOrigen][posDestino];
		a.setExiste(false);
	}


	// Pre: existeVertice(vert)
	public ILista<String> verticesAdyacentes(String vert) {
		ILista<String> retorno = new Lista<String>();
		int pos = obtenerPos(vert);
		for (int i = 0; i < tope; i++) {
			if (matAdy[pos][i].isExiste()) {
				retorno.insertar(vertices[pos]);
			}
		}
		return retorno;
	}

	// Pre: existeVertice(vert)
	public ILista<String> verticesIncidentes(String vert) {
		ILista<String> retorno = new Lista<String>();
		int pos = obtenerPos(vert);
		for (int i = 0; i < tope; i++) {
			if (matAdy[i][pos].isExiste()) {
				retorno.insertar(vertices[pos]);
			}
		}
		return retorno;
	}


	// ------------ DFS ------------
	
	// Pre: existeVertice(vert)
	public void dfs(String vert) {
		System.out.println(" --- DFS --- ");
		int pos = obtenerPos(vert);
		boolean[] visitados = new boolean[this.tope];
		dfsRec(pos, visitados);
	}

	private void dfsRec(int pos, boolean[] visitados) {
		System.out.println(vertices[pos]);
		visitados[pos] = true;
		for (int j = 0; j < tope; j++) {
			if (this.matAdy[pos][j].isExiste() && !visitados[j]) {
				dfsRec(j, visitados);
			}
		}
	}


	// ------------ BFS ------------

	// Pre: existeVertice(vert)
	public void bfs(String vert) {
		System.out.println(" --- BFS --- ");
		int pos = obtenerPos(vert);
		boolean[] visitados = new boolean[tope];
		Cola<Integer> cola = new Cola<>();
		cola.encolar(pos);
		while (!cola.esVacia()) {
			pos = cola.desencolar();
			System.out.println(vertices[pos]);
			visitados[pos] = true;
			for (int j = 0; j < tope; j++) {
				if (this.matAdy[pos][j].isExiste() && !visitados[j]) {
					cola.encolar(j);
				}
			}
		}
	}




	
	
	
	
}
