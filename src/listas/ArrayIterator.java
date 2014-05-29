package listas;

import java.util.*;
/**
 * Para iterar sobre estructuras array T[]
 */
public class ArrayIterator<T> implements Iterator<T> {
	
	private int count;   //n�mero de elementos de la colecci�n
	private int current; // posici�n actual de recorrido
	private T[] items;   
	
	// Inicializa un iterador para recorrer la colecci�n especificada
	public ArrayIterator (T[] collection, int size) {
		items = collection;
		count = size;
		current = 0;
	}
	
	// Devuelve true si la colecci�n tiene al menos un elemento m�s,
	// que todav�a no ha sido visitado
	public boolean hasNext(){
		return (current < count);
	}
	
	// Devuelve el siguiente elemento de la colecci�n, seg�n el recorrido. 
	// Se supone que hay elemento siguiente.
	public T next(){
		if (! hasNext())
			throw new NoSuchElementException();
		current ++;
		return items[current-1];
	}
	
	public void remove() throws UnsupportedOperationException {
		throw new  UnsupportedOperationException();
	}

}
