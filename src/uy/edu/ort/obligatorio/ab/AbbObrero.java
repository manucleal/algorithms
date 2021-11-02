package uy.edu.ort.obligatorio.ab;

import uy.edu.ort.obligatorio.Retorno;
import uy.edu.ort.obligatorio.Retorno.Resultado;
import uy.edu.ort.obligatorio.obrero.NodoObrero;
import uy.edu.ort.obligatorio.obrero.Obrero;

public class AbbObrero {
	
	private NodoObrero raiz;
	
	public AbbObrero(NodoObrero unaRaiz) {
		this.raiz = unaRaiz;
	}

	public NodoObrero getRaiz() {
		return this.raiz;
	}

	// pre: dato no existe en el arbol
	public void insertar(Obrero dato) {
		if (this.raiz == null) {
			this.raiz = new NodoObrero(dato);
		} else {			
			insertarRec(this.raiz, dato);
		}
	}

	// pre nodo != null
	private void insertarRec(NodoObrero nodo, Obrero dato) {
		if (sanitizeDocument(dato.getCedula()) > sanitizeDocument(nodo.getDato().getCedula())) {
			if (nodo.getDerecha() == null) {
				nodo.setDerecha(new NodoObrero(dato));
			} else {
				insertarRec(nodo.getDerecha(), dato);
			}
		} else {
			if (nodo.getIzquierda() == null) {
				nodo.setIzquierda(new NodoObrero(dato));
			} else {
				insertarRec(nodo.getIzquierda(), dato);
			}
		}
	}
	
	private static int sanitizeDocument(String document) {
		return Integer.parseInt(document.replace(".", "").replace("-", ""));
	}
	
	public Retorno pertenece(String dato) {
		return perteneceRec(this.raiz, dato);
	}

	private Retorno perteneceRec(NodoObrero nodo, String dato) {
		if (nodo == null) {
			return new Retorno(Resultado.ERROR_2);
		} else if (nodo.getDato().getCedula().equals(dato)) {
			String cedulaNombre = nodo.toString();
			return new Retorno(Resultado.OK, 1, cedulaNombre);
		} else {
			if (sanitizeDocument(dato) > sanitizeDocument(nodo.getDato().getCedula())) {
				Retorno retorno = perteneceRec(nodo.getDerecha(), dato);
				retorno.valorEntero++;
				return retorno;
			} else {
				Retorno retorno = perteneceRec(nodo.getIzquierda(), dato);
				retorno.valorEntero++;
				return retorno;
			}
		}
	}
	
	public String listarAsc() {
		String listadoObreros = listarAscRec(this.raiz);
		return listadoObreros.substring(0, listadoObreros.length() - 1);
	}

	private String listarAscRec(NodoObrero nodo) {
		if (nodo != null) {
			String izquierda = listarAscRec(nodo.getIzquierda());
			izquierda += nodo.getDato().getCedula() + ";" + nodo.getDato().getNombre();
			String derecha = listarAscRec(nodo.getDerecha());
			return izquierda + "|" + derecha;
		}
		return "";
	}
}
