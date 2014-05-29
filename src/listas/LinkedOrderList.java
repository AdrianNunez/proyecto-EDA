package listas;

import java.util.Iterator;



public class LinkedOrderList<T extends Comparable<T>> implements ListaOrdenadaTAD<T>  {

	private DoubleNode<T> first;
	private DoubleNode<T> last;
	private int length;
	
	public LinkedOrderList (){
		first = null;
		last = null;
		length = 0;
	}
	
	public void clear()
	{
		first = null;
		last = null;
		length = 0;
	}
	
	//Elimina y devuelve el primer elemento de la lista
	public T removeFirst(){
		if( length>0 ){
			DoubleNode<T> temp = first;
			if( length==1 )   // la lista tiene sólo un elemento
				last = null;
			else		
				first.getNext().setPrevious(null);
			first = first.getNext();
			length--;
			return temp.getElement();
		}
		else
			return null;
	}
	
	//Elimina y devuelve el último elemento de la lista
	public T removeLast(){
		if ( length>0 ){
			DoubleNode<T> temp = last;
			if( length==1 )//la lista tiene sólo un elemento
				first = null;
			else
				last.getPrevious().setNext(null);
			last = last.getPrevious();
			length--;
			return temp.getElement();
		}
		else
			return null;
	}
	
	//Elimina y devuelve el elemento especificado de la lista
	public T remove (T element){
		if(length>0){
			DoubleNode<T> actual = first;
			while(actual!=null && !actual.getElement().equals(element)) //buscamos el elemento
				actual=actual.getNext();
			//actual apunta al elemento buscado o a null
			if ( actual == null )
				return null;
			else // (actual.data.equals(element))  element está en la lista
				if (actual==first)
					return removeFirst();
				else if(actual==last)
					return removeLast();
				else {
					actual.getNext().setPrevious( actual.getPrevious() );
					actual.getPrevious().setNext( actual.getNext() );
					length--;
					return (actual.getElement());
				}
		}
		else //Si llega aquí es que length == 0
			return null;
	}
	
	//Devuelve una referencia al primer elemento de la lista
	public T first (){
		if(length>0)
			return(first.getElement());
		else
			return null;
	}
	
	//Devuelve una referencia al último elemento de la lista
	public T last (){
		if(length>0)
			return last.getElement();
		else
			return null;
	}
	
	//Devuelve true si esta lista contiene el elemento especificado
	public boolean contains (T target){
		if(length==0)
			return false;
		else {
			DoubleNode<T> actual = first;
			while(actual!=null && (!actual.getElement().equals(target))) //buscamos el elemento
				actual = actual.getNext();
			if (actual == null) 
				return false;
			else
				return true;	
		}
	}
	
	//Devuelve true si esta lista no contiene ningún elemento
	public boolean isEmpty (){
		return (length==0);
	}
	
	//Devuelve el número de elementos de la lista
	public int size (){
		return(length);
	}
	
	//Devuelve un iterador para los elementos de la lista,
	//para recorrerlos de principio a fin
	public Iterator<T> iterator(){
		return new IteradorLigadaDoble<T>(first);
	}
	
	//Devuelve un iterador para los elementos de la lista, 
	//para recorrerlos desde el final al principio
	public Iterator<T> iteratorInv(){
		return new IteradorLigadaDobleInv<T>(last);
	}
	
	//Añade un elemento a la lista (en el lugar de orden que le corresponde)
	public void add (T elem){
		DoubleNode<T> nuevo = new DoubleNode<T>(elem);
		DoubleNode<T> actual = first;
		
		while(actual!=null && actual.getElement().compareTo(elem)<0)
			//La lista no es vacía Y no ha encontrado la posición
			{
			actual=actual.getNext();
			}
		if(actual==null){ //la lista es vacía o se inserta al final
			if (first!=null){ //insertar al final
				last.setNext( nuevo );
				nuevo.setPrevious( last );
				last=nuevo;				
				}
			else{ //la lista es vacía
				last=nuevo;
				first=nuevo;
				}
		}
	    else if(actual==first){  //inserción al principio
			nuevo.setNext( first );
			first.setPrevious( nuevo );
			first = nuevo;}
		else { 
		nuevo.setNext( actual );
		nuevo.setPrevious( actual.getPrevious() );
		actual.setPrevious( nuevo );
		nuevo.getPrevious().setNext( nuevo );		
		}
		length++;
		
	}

		
}
	