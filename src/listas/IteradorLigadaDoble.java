package listas;

import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * Para iterar sobre estructuras ligadas con nodos DoubleNode<T>
 * recorriendo desde el principio al final
 */


public class IteradorLigadaDoble<T> implements Iterator<T> {
	
	private DoubleNode<T> current;  // la posici�n actual 
	
	// Inicializa un iterador para recorrer la colecci�n especificada
	public IteradorLigadaDoble (DoubleNode<T> collection){
		current = collection;
	}
	
	// Devuelve true si la colecci�n tiene al menos un elemento m�s,
	// que todav�a no ha sido visitado
	public boolean hasNext(){
		return ( current != null);
	}
	
	// Devuelve el siguiente elemento de la colecci�n, seg�n el recorrido. 
	// Se supone que hay elemento siguiente.
	public T next(){
		if (! hasNext())
			throw new NoSuchElementException();
		T result = current.getElement();
		current = current.getNext();
		return result;
	}
	
	public void remove() throws UnsupportedOperationException {
		throw new  UnsupportedOperationException();
	}
}
