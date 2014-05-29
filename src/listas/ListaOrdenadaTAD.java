//---------------------------------------------------------
// Interfaz para listas ordenadas.
// Sólo se almacenarán elementos de tipo Comparable 
// para poder disponer de la relación de orden 
// que organiza la lista.
//---------------------------------------------------------
package listas;

public interface ListaOrdenadaTAD<T extends Comparable<T>> extends ListADT<T> {
	
	//Añade a la lista el elemento especificado, 
	//ubicándolo en el lugar que le corresponde 
	//por la relación de orden en T
	public void add (T element);

}
