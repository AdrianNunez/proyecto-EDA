package proyecto;

import java.util.Hashtable;
import java.util.Enumeration;

public class AlmacenEntidades
{
	private Hashtable<String,Integer> coleccion;
	
	public AlmacenEntidades()
	{
		coleccion = new Hashtable<String,Integer>();
	}
	
	public void clear()
	{
		coleccion.clear();
	}
	
	public void añadirElemento (String entidad)
	{
		if(!coleccion.containsKey(entidad))
			coleccion.put(entidad, 1);
		else 
			coleccion.put(entidad, coleccion.get(entidad)+1);
	}
	
	public void imprimir()
	{
		if(this.coleccion.isEmpty())
		{
			System.out.println("El almacen esta vacio.");
			return;
		}
		Enumeration<String> entidades = coleccion.keys();
		int i = 1;
		while(entidades.hasMoreElements())
		{
			System.out.println(i + "=> " + entidades.nextElement());
			i++;
		}
	}
	
}
