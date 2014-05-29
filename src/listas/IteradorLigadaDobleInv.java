package listas;

import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * Para iterar sobre estructuras ligadas con nodos DoubleNode<T>
 * desde el final hasta el principio
 */


public class IteradorLigadaDobleInv<T> implements Iterator<T> {
	
	private DoubleNode<T> current;  // la posición actual 
	
	// Inicializa un iterador para recorrer la colección especificada
	public IteradorLigadaDobleInv (DoubleNode<T> collection){
		current = collection;
	}
	
	// Devuelve true si la colección tiene al menos un elemento más,
	// que todavía no ha sido visitado
	public boolean hasNext(){
		return ( current != null);
	}
	
	// Devuelve el siguiente elemento de la colección, según el recorrido, 
	// que en este caso es el que ocupa la posición previa en la lista.
	// Se supone que hay elemento siguiente.
	public T next(){
		if (! hasNext())
			throw new NoSuchElementException();
		T result = current.getElement();
		current = current.getPrevious();
		return result;
	}
	
	public void remove() throws UnsupportedOperationException {
		throw new  UnsupportedOperationException();
	}

}
