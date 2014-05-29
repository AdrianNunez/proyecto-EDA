package listas;

import java.util.*;
/**
 * Para iterar sobre estructuras ligadas con nodos LinearNode<T>
 * Es la clase de nodos que se utiliza en el capítulo 4 de [Lewis, Chase 2006]
 */
public class LinkedIterator<T> implements Iterator<T> {
	
	//private int count; //aparece en el libro pero es innecesaria
	private LinearNode<T> current;  // la posición actual 
	
	// Inicializa un iterador para recorrer la colección especificada
	public LinkedIterator (LinearNode<T> collection, int size){
		current = collection;
		//count = size; No se utiliza. Dejo el parámetro size por seguir el libro.
	}
	
	// Devuelve true si la colección tiene al menos un elemento más,
	// que todavía no ha sido visitado
	public boolean hasNext(){
		return ( current != null);
	}
	
	// Devuelve el siguiente elemento de la colección, según el recorrido. 
	// Se supone que hay elemento siguiente.
	public T next(){
		if (! hasNext())
			throw new NoSuchElementException();
		T result = current.getElement();
		current = current.getNext();
		return result;
	}
	
	// La operación de eliminación no está soportada
	public void remove() throws UnsupportedOperationException {
		throw new  UnsupportedOperationException();
	}
}
