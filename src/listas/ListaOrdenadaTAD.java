//---------------------------------------------------------
// Interfaz para listas ordenadas.
// S�lo se almacenar�n elementos de tipo Comparable 
// para poder disponer de la relaci�n de orden 
// que organiza la lista.
//---------------------------------------------------------
package listas;

public interface ListaOrdenadaTAD<T extends Comparable<T>> extends ListADT<T> {
	
	//A�ade a la lista el elemento especificado, 
	//ubic�ndolo en el lugar que le corresponde 
	//por la relaci�n de orden en T
	public void add (T element);

}
