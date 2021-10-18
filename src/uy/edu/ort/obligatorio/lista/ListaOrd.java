package lista;

public class ListaOrd<T extends Comparable<T>> extends Lista<T>{
    
    @Override
    public void insertar(T dato){
        if(inicio == null || dato.compareTo(inicio.getDato()) <= 0){
            inicio = new NodoLista<T>(dato, inicio);
        }else{
            NodoLista<T> aux = inicio;
            while(aux.getSig() != null && dato.compareTo(aux.getSig().getDato()) > 0  ){
                aux = aux.getSig();
            }
            aux.setSig(new NodoLista<T>(dato, aux.getSig()));
        }
        largo++;
    }
}
