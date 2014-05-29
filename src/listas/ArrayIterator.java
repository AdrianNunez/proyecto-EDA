package listas;

import java.util.*;
/**
 * Para iterar sobre estructuras array T[]
 */
public class ArrayIterator<T> implements Iterator<T> {
	
	private int count;   //número de elementos de la colección
	private int current; // posición actual de recorrido
	private T[] items;   
	
	// Inicializa un iterador para recorrer la colección especificada
	public ArrayIterator (T[] collection, int size) {
		items = collection;
		count = size;
		current = 0;
	}
	
	// Devuelve true si la colección tiene al menos un elemento más,
	// que todavía no ha sido visitado
	public boolean hasNext(){
		return (current < count);
	}
	
	// Devuelve el siguiente elemento de la colección, según el recorrido. 
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
