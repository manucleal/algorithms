package uy.edu.ort.obligatorio.mapa;

import uy.edu.ort.obligatorio.ISistema.Estado;
import uy.edu.ort.obligatorio.Retorno.Resultado;
import uy.edu.ort.obligatorio.Retorno;
import uy.edu.ort.obligatorio.cola.Cola;

public class Mapa {
	
	private int tope;
	
	private int cantidad;
	
	private Poste[] postes;
	
	private Tramo[][] tramos;
	
	public Mapa() {}
	
	// PRE: !esDirigido
	public Mapa(int unTope) {
		this.tope = unTope;
		this.inicializarPostes();
		this.tramos = new Tramo[this.tope][this.tope];
		for (int i = 0; i < this.tope; i++) {
			for (int j = 0; j < this.tope; j++) {
				this.tramos[i][j] = new Tramo();
				this.tramos[j][i] = this.tramos[i][j];
			}
		}
	}
	
	private void inicializarPostes() {
		this.setPostes(new Poste[this.tope]);
		for(int i = 0; i < this.tope; i++) {
			this.postes[i] = new Poste();
		}
	}

	public void setPostes(Poste[] postes) {
		this.postes = postes;
	}
	
	public boolean existePoste(double coordX, double coordY) {
		return this.obtenerPosPoste(coordX, coordY) != -1;
	}
	
	public int obtenerPosPoste(double coordX, double coordY) {
		Poste auxPoste = new Poste(coordX, coordY);
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
	public boolean existeTramo(double coordXorigen, double coordYorigen, double coordXdestino, double coordYdestino) {
		int posOrigen = obtenerPosPoste(coordXorigen, coordYorigen);
		int posDestino = obtenerPosPoste(coordXdestino, coordYdestino);
		return this.tramos[posOrigen][posDestino].isExiste();
	}
	
	//PRE: existeVertice(Origen) && existeVertice(destino) && !existeArista
	public void agregarTramo(double coordXi, double coordYi, double coordXf, double coordYf, double metros) {
		
		int posOrigen = obtenerPosPoste(coordXi, coordYi);
		int posDestino = obtenerPosPoste(coordXf, coordYf);
		
		Tramo t = this.tramos[posOrigen][posDestino];
		t.setExiste(true);
		t.setMetros(metros);
		t = this.tramos[posDestino][posOrigen];
		t.setExiste(true);
		t.setMetros(metros);
	}
	
	public boolean esLleno() {
		return this.cantidad == this.tope;
	}
	
	public boolean esVacio() {
		return this.cantidad == 0;
	}

	public void actualizarTramo(double coordXi, double coordYi, double coordXf, double coordYf, double metros, Estado estado) {
		int posOrigen = obtenerPosPoste(coordXi, coordYi);
		int posDestino = obtenerPosPoste(coordXf, coordYf);
		
		Tramo t = this.tramos[posOrigen][posDestino];
		t.setMetros(metros);
		t.setEstados(estado);

		t = this.tramos[posDestino][posOrigen];
		t.setMetros(metros);
		t.setEstados(estado);
	}
	
	public String bfs(double coordXorigen, double coordYorigen, int cantTramosMaximo) {
		int pos = obtenerPosPoste(coordXorigen, coordYorigen);
		boolean[] visitados = new boolean[tope];
		int[] level = new int[tope];
		Cola<Integer> cola = new Cola<>();
		cola.encolar(pos);
		visitados[pos] = true;
		String mostrarRecorrido = "";
		
		while (!cola.esVacia()) {					
			pos = cola.desencolar();
			mostrarRecorrido += this.postes[pos].toString();
			for (int j = 0; j < tope; j++) {
				if (this.tramos[pos][j].isExiste() && !visitados[j]) {
					level[j] = level[pos] + 1;
					if (level[j] <= cantTramosMaximo) {
						cola.encolar(j);
						visitados[j] = true;						
					}
				}
			}
		}
		return mostrarRecorrido.substring(0, mostrarRecorrido.length() - 1);
	}
	
	/*
	 * inicializar estructuras
	 * Marcar el origen con distancia cero.
	 * 	Loop:
	 * 1) Obtener el vértice no visitado de menor costo (si hay varios cualquiera)
	 * 2) Visitarlo
	 * 3) Evaluar si tengo que actualizar el costo de los adyacentes NO VISITADOS. 
	*/

	public Retorno dijkstra(double coordXorigen, double coordYorigen, double coordXdestino, double coordydestino) {
		int posOrigen = obtenerPosPoste(coordXorigen, coordYorigen);
		int posDestino = obtenerPosPoste(coordXdestino, coordydestino);
		
		boolean[] visitados = new boolean[tope];
		double[] costos = this.iniciarVectorCostos();
		Poste[] anteriores = new Poste[tope];
		
		costos[posOrigen] = 0;
		
		for (int i = 0; i < this.cantidad; i++) {
			int pos = this.obtenerSiguienteVerticeNoVisitadoDeMenorCosto(costos, visitados);
			if (pos != -1) {
				visitados[pos] = true;
				
				for (int j = 0; j < this.tope; j++) {
					Tramo tramo = this.tramos[pos][j];
					if(tramo.isExiste() && tramo.getEstado() != Estado.MALO && !visitados[j]) {
						double distanciaNueva = costos[pos] + tramo.getMetros();
						if(distanciaNueva < costos[j]) {
							costos[j] = distanciaNueva;
							anteriores[j] = this.postes[pos];
						}
					}
				}
			}
		}
		String camino = obtenerCaminoMinimo(anteriores, posOrigen, posDestino); // Armar camino.
		
		Retorno result = new Retorno(Resultado.OK, 
				(int) costos[posDestino], 
				camino); 
		
		
		return result;
	}
	
	private String obtenerCaminoMinimo(Poste[] anteriores, int posOrigen, int posActual) {
		if (posActual == posOrigen) {
			return this.postes[posActual].toString();
		}
		int posAnterior = obtenerPosPoste(anteriores[posActual].getCoordX(), anteriores[posActual].getCoordY());
		String camino = this.obtenerCaminoMinimo(anteriores, posOrigen, posAnterior)
				+ this.postes[posActual].toString();
		
		return camino;
	}
	
	private int obtenerSiguienteVerticeNoVisitadoDeMenorCosto(double[] costos, boolean[] visitados) {
		double menorCosto = Double.MAX_VALUE;
		int posMin = -1;
		for (int i = 0; i < tope; i++) {
			if(!visitados[i] && costos[i] < menorCosto) {
				menorCosto = costos[i];
				posMin = i;
			}				
		}
					
		return posMin;
	}
	
	private double[] iniciarVectorCostos() {
		double[] costo = new double[tope];
		for (int i = 0; i < tope; i++) {
			costo[i] = Integer.MAX_VALUE;
		}
		return costo;
	}

}
