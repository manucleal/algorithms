package lista;

public interface ILista<T> extends Iterable<T> {
	
	public void insertar(T dato);

	public void borrar(T dato);

	public int largo();

	public boolean existe(T dato);

	public T recuperar(T dato);

	public boolean esVacia();

	public boolean esLlena();
}
