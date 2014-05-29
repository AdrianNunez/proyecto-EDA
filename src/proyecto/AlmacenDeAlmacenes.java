package proyecto;

import java.util.ArrayList;
import java.util.Enumeration;

public class AlmacenDeAlmacenes
{
	private ArrayList<Almacen> almacenes;
	
	public AlmacenDeAlmacenes()
	{
		almacenes = new ArrayList<Almacen>();
	}
	public void clear(){
		almacenes.clear();
	}
	public void a�adirAlmacen(Almacen alm)
	{
		almacenes.add(alm);
	}
	
	//METODO 5
	public AlmacenEntidades interseccion()
	{
		if(almacenes.isEmpty()) return new AlmacenEntidades();
		AlmacenEntidades alm = new AlmacenEntidades();
		int min = Integer.MAX_VALUE, indice = 0, i = 0;
		// Vamos a buscar el almac�n m�s peque�o
		// y a guardar su posici�n en indice
		while(i<almacenes.size())
		{
			if(almacenes.get(i).size()<min)
			{
				min = almacenes.get(i).size();
				indice = i;
			}
			i++;
		}
		Almacen A = almacenes.get(indice);
		// Obtenemos todos los sujetos del almacen mas peque�o
		Enumeration<String> sujetos = A.grafo.keys();
		String sujeto;
		boolean salir = false;
		while(sujetos.hasMoreElements())
		{
			sujeto=sujetos.nextElement();
			i = 0;
			// Comprobamos que el sujeto i-esimo esta en todos los almacenes
			while(!salir && i<almacenes.size()){
				if(i!=indice && !almacenes.get(i).grafo.containsKey(sujeto))
					salir = true;
				i++;
			}
			// Si esta en todos a�adimos al almacen
			if(!salir)
				alm.a�adirElemento(sujeto);
		}
		return alm;
	}
}
