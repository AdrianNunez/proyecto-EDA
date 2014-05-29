//--------------------------------------------------------
// Interfaz com�n a todas las listas.
// Los tipos espec�ficos de lista extender�n esta interfaz
// para completar el conjunto de operaciones pertinentes.
//---------------------------------------------------------
package listas;
import java.util.Iterator;

public interface ListADT<T> {
	//Elimina y devuelve el primer elemento de la lista
	public T removeFirst();
	
	//Elimina y devuelve el �ltimo elemento de la lista
	public T removeLast();
	
	//Elimina y devuelve el elemento especificado de la lista
	public T remove (T element);
	
	//Devuelve una referencia al dato del primer elemento de la lista
	public T first ();
	
	//Devuelve una referencia al dato del �ltimo elemento de la lista
	public T last ();
	
	//Devuelve true si esta lista contiene el elemento especificado
	public boolean contains (T target);
	
	//Devuelve true si esta lista no contiene ning�n elemento
	public boolean isEmpty ();
	
	//Devuelve el n�mero de elementos de la lista
	public int size ();
	
	//Devuelve un iterador para los elementos de la lista
	public Iterator<T> iterator();
	
}
