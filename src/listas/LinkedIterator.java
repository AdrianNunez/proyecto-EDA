package listas;

import java.util.*;
/**
 * Para iterar sobre estructuras ligadas con nodos LinearNode<T>
 * Es la clase de nodos que se utiliza en el cap�tulo 4 de [Lewis, Chase 2006]
 */
public class LinkedIterator<T> implements Iterator<T> {
	
	//private int count; //aparece en el libro pero es innecesaria
	private LinearNode<T> current;  // la posici�n actual 
	
	// Inicializa un iterador para recorrer la colecci�n especificada
	public LinkedIterator (LinearNode<T> collection, int size){
		current = collection;
		//count = size; No se utiliza. Dejo el par�metro size por seguir el libro.
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
	
	// La operaci�n de eliminaci�n no est� soportada
	public void remove() throws UnsupportedOperationException {
		throw new  UnsupportedOperationException();
	}
}
