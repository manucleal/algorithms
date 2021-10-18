package uy.edu.ort.obligatorio.ab;

public class Abb {
	
	private NodoAb raiz;

	public Abb() {
		this.raiz = null;
	}

	public Abb(NodoAb unaRaiz) {
		this.raiz = unaRaiz;
	}

	public NodoAb getRaiz() {
		return raiz;
	}

	// Pos: Retorna la cantidad de nodos del AB.
	public int cantidadDeNodos() {
		return cantidadDeNodos(this.raiz);
	}

	private int cantidadDeNodos(NodoAb unaRaiz) {
		if (unaRaiz == null) {
			return 0;
		} else {
			int cantIzq = cantidadDeNodos(unaRaiz.getIzquierda());
			int cantDer = cantidadDeNodos(unaRaiz.getDerecha());
			return cantIzq + cantDer + 1;
			// return cantidadDeNodos(unaRaiz.getIzquierda()) + cantidadDeNodos(unaRaiz.getDerecha())
			// + 1;
		}
	}

	// Pos: Retorna un nuevo AB resultado de copiar todos los elementos del AB
	// actual en el nuevo árbol.
	// Nota: Se debe crear un AB nuevo e independiente en memoria.
	public static Abb clon(Abb a) {
		NodoAb raizClonada = clonRec(a.getRaiz());
		return new Abb(raizClonada);
	}

	private static NodoAb clonRec(NodoAb nodo) {
		if (nodo == null) {
			return null;
		} else {
			NodoAb nuevo = new NodoAb(nodo.getDato());
			nuevo.setIzquierda(nodo);
			nuevo.setDerecha(clonRec(nodo.getDerecha()));
			return nuevo;
		}
	}

	public boolean pertenece(int dato) {
		return perteneceRec(this.raiz, dato);
	}

	private boolean perteneceRec(NodoAb nodo, int dato) {
		if (nodo == null) {
			return false;
		} else if (nodo.getDato() == dato) {
			return true;
		} else {
			if (dato > nodo.getDato()) {
				return perteneceRec(nodo.getDerecha(), dato);
			} else {
				return perteneceRec(nodo.getIzquierda(), dato);
			}
		}
	}

	public void listarAsc() {
		listarAscRec(this.raiz);
	}

	private void listarAscRec(NodoAb nodo) {
		if (nodo != null) {
			listarAscRec(nodo.getIzquierda());
			System.out.println(nodo.getDato());
			listarAscRec(nodo.getDerecha());
		}
	}

	public void listarDes() {
		listarDesRec(this.raiz);
	}

	private void listarDesRec(NodoAb nodo) {
		if (nodo != null) {
			listarDesRec(nodo.getDerecha());
			System.out.println(nodo.getDato());
			listarDesRec(nodo.getIzquierda());
		}
	}

	// pre: dato no existe en el arbol
	public void insertar(int dato) {
		if (this.raiz == null) {
			this.raiz = new NodoAb(dato);
		} else {
			insertarRec(this.raiz, dato);
		}
	}

	// pre nodo != null
	private void insertarRec(NodoAb nodo, int dato) {
		if (dato > nodo.getDato()) {
			if (nodo.getDerecha() == null) {
				nodo.setDerecha(new NodoAb(dato));
			} else {
				insertarRec(nodo.getDerecha(), dato);
			}
		} else {
			if (nodo.getIzquierda() == null) {
				nodo.setIzquierda(new NodoAb(dato));
			} else {
				insertarRec(nodo.getIzquierda(), dato);
			}
		}
	}

	// pre: dato no existe en el arbol
	public void insertarV2(int dato) {
		this.raiz = insertarRecV2(this.raiz, dato);
	}

	// pre nodo != null
	private NodoAb insertarRecV2(NodoAb nodo, int dato) {
		if (nodo == null) {
			nodo = new NodoAb(dato);		
		} else if (dato > nodo.getDato()) {
			nodo.setDerecha(insertarRecV2(nodo.getDerecha(), dato));	
		} else {
			nodo.setIzquierda(insertarRecV2(nodo.getIzquierda(), dato));	
		}
		return nodo;
	}
	
	//pre arbol != vacio
	public void borrarMin() {
		if(this.raiz.getIzquierda() == null) {
			this.raiz = this.raiz.getDerecha();
		}else {
			borrarMinRec(this.raiz);
		}
	}

	private void borrarMinRec(NodoAb nodo) {
		if(nodo.getIzquierda().getIzquierda() == null) {
			nodo.setIzquierda(nodo.getIzquierda().getDerecha());
		}else {
			borrarMinRec(nodo.getIzquierda());
		}
	}
	
	//pre arbol != vacio
	public void borrarMinV3() {
		this.raiz = borrarMinRecV3(this.raiz);	
	}

	private NodoAb borrarMinRecV3(NodoAb nodo) {
		if(nodo.getIzquierda() == null) {
			nodo = nodo.getDerecha();
		}else {
			nodo.setIzquierda(borrarMinRecV3(nodo.getIzquierda()));
		}
		return nodo;
	}


	private int borrarMinRecV2(NodoAb nodo) {
		if (nodo.getIzquierda().getIzquierda() == null) {
			int ret = nodo.getIzquierda().getDato();
			nodo.setIzquierda(nodo.getIzquierda().getDerecha());
			return ret;
		} else
			return borrarMinRecV2(nodo.getIzquierda());
	}

	// Pre: El elemento x pasado como parametro pertenece al Abb.
	// Pos:Elimina el elemento x del Abb, manteniendolo ordenado.
	public void borrarElemento(int dato) {
		if (raiz.getDato() == dato) {
			if (raiz.getIzquierda() == null && raiz.getDerecha() == null) {
				raiz = null;
			} else if (raiz.getIzquierda() == null || raiz.getDerecha() == null) {
				if (raiz.getIzquierda() == null) {
					raiz = raiz.getDerecha();
				} else {
					raiz = raiz.getIzquierda();
				}
			} else {
				if (raiz.getDerecha().getIzquierda() == null) {
					raiz.setDato(raiz.getDerecha().getDato());
					raiz.setDerecha(raiz.getDerecha().getDerecha());
				} else {
					raiz.setDato(borrarMinRecV2(raiz.getDerecha()));
				}
			}
		} else
			borrarRec(raiz, dato);
	}

	private void borrarRec(NodoAb nodo, int dato) {
		if (dato < nodo.getDato()) {
			if (nodo.getIzquierda().getDato() == dato) {
				if (nodo.getIzquierda().getIzquierda() == null && nodo.getIzquierda().getDerecha() == null)
					nodo.setIzquierda(null);
				else if (nodo.getIzquierda().getIzquierda() == null || nodo.getIzquierda().getDerecha() == null) {
					if (nodo.getIzquierda().getIzquierda() == null) {
						nodo.setIzquierda(nodo.getIzquierda().getDerecha());
					} else {
						nodo.setIzquierda(nodo.getIzquierda().getIzquierda());
					}
				} else {
					if (nodo.getIzquierda().getDerecha().getIzquierda() == null) {
						nodo.getIzquierda().setDato(nodo.getIzquierda().getDerecha().getDato());
						nodo.getIzquierda().setDerecha(nodo.getIzquierda().getDerecha().getDerecha());
					} else {
						nodo.getIzquierda().setDato(borrarMinRecV2(nodo.getIzquierda().getDerecha()));
					}
				}
			} else
				borrarRec(nodo.getIzquierda(), dato);
		} else if (dato > nodo.getDato()) {
			if (nodo.getDerecha().getDato() == dato) {
				if (nodo.getDerecha().getIzquierda() == null && nodo.getDerecha().getDerecha() == null)
					nodo.setDerecha(null);
				else if (nodo.getDerecha().getIzquierda() == null || nodo.getDerecha().getDerecha() == null) {
					if (nodo.getDerecha().getIzquierda() == null) {
						nodo.setDerecha(nodo.getDerecha().getDerecha());
					} else {
						nodo.setDerecha(nodo.getDerecha().getIzquierda());
					}
				} else {
					if (nodo.getDerecha().getDerecha().getIzquierda() == null) {
						nodo.getDerecha().setDato(nodo.getDerecha().getDerecha().getDato());
						nodo.getDerecha().setDerecha(nodo.getDerecha().getDerecha().getDerecha());
					} else {
						nodo.getDerecha().setDato(borrarMinRecV2(nodo.getDerecha().getDerecha()));
					}
				}
			} else {
				borrarRec(nodo.getDerecha(), dato);
			}
		}
	}
}
