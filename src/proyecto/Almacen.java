package proyecto;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.*;
import listas.LinkedOrderList;

public class Almacen {

	protected Hashtable<String,ArrayList<Hashtable<String,Hashtable<String,Integer>>>> grafo;
	private Hashtable<String,String> aristas;
	private int size;
	
	public Almacen()
	{
		grafo = new Hashtable<String,ArrayList<Hashtable<String,Hashtable<String,Integer>>>>();
		aristas = new Hashtable<String,String>();
		size = 0;
	}
	
	public int size()
	{
		return this.size;
	}
	
	public int esta(Sentencia s)
	{
		if(grafo.containsKey(s.verSujeto()) && grafo.get(s.verSujeto()).get(0).containsKey(s.verPropiedad()) && grafo.get(s.verSujeto()).get(0).get(s.verPropiedad()).containsKey(s.verObjeto()))
			return grafo.get(s.verSujeto()).get(0).get(s.verPropiedad()).get(s.verObjeto());
		return 0;
	}
	
	public void clear()
	{
		Enumeration<String> sujetos,propiedades, propiedades2;
		sujetos = grafo.keys();
		String sujeto, propiedad;
		
		while(sujetos.hasMoreElements())
		{
			sujeto = sujetos.nextElement();
			propiedades = grafo.get(sujeto).get(0).keys();
			propiedades2 = grafo.get(sujeto).get(1).keys();
			while(propiedades.hasMoreElements())
			{
				propiedad = propiedades.nextElement();
					grafo.get(sujeto).get(0).get(propiedad).clear();
			}
			grafo.get(sujeto).get(0).clear();
			while(propiedades2.hasMoreElements())
			{
				propiedad = propiedades2.nextElement();
				grafo.get(sujeto).get(1).get(propiedad).clear();
			}
			grafo.get(sujeto).get(1).clear();
		}
		grafo.clear();
	}
	
	public void añadirElemento(Sentencia sent)
	{   
		//                                                  ______________
		//                                                 |              |
		//                                                 | 0=Out & 1=In |
		//                                                 |______________|
		if(!grafo.containsKey(sent.verSujeto())){
			grafo.put(sent.verSujeto(), new ArrayList<Hashtable<String,Hashtable<String,Integer>>>(2));
			grafo.get(sent.verSujeto()).add(0,new Hashtable<String,Hashtable<String,Integer>>());
			grafo.get(sent.verSujeto()).add(1,new Hashtable<String,Hashtable<String,Integer>>());
			}
		if(!grafo.get(sent.verSujeto()).get(0).containsKey(sent.verPropiedad()))
			grafo.get(sent.verSujeto()).get(0).put(sent.verPropiedad(), new Hashtable<String,Integer>());
		if(!grafo.get(sent.verSujeto()).get(0).get(sent.verPropiedad()).containsKey(sent.verObjeto()))
			grafo.get(sent.verSujeto()).get(0).get(sent.verPropiedad()).put(sent.verObjeto(), 1);
		
		else
			grafo.get(sent.verSujeto()).get(0).get(sent.verPropiedad()).put(sent.verObjeto(), grafo.get(sent.verSujeto()).get(0).get(sent.verPropiedad()).get(sent.verObjeto())+1);
		//indegree
		if(!grafo.containsKey(sent.verObjeto())){
			grafo.put(sent.verObjeto(), new ArrayList<Hashtable<String,Hashtable<String,Integer>>>(2));
			grafo.get(sent.verObjeto()).add(0,new Hashtable<String,Hashtable<String,Integer>>());
			grafo.get(sent.verObjeto()).add(1,new Hashtable<String,Hashtable<String,Integer>>());
			}
		if(!grafo.get(sent.verObjeto()).get(1).containsKey(sent.verPropiedad()))
			grafo.get(sent.verObjeto()).get(1).put(sent.verPropiedad(), new Hashtable<String,Integer>());
		if(!grafo.get(sent.verObjeto()).get(1).get(sent.verPropiedad()).containsKey(sent.verSujeto()))
			grafo.get(sent.verObjeto()).get(1).get(sent.verPropiedad()).put(sent.verSujeto(), 1);
		else
			grafo.get(sent.verObjeto()).get(1).get(sent.verPropiedad()).put(sent.verSujeto(), grafo.get(sent.verObjeto()).get(1).get(sent.verPropiedad()).get(sent.verSujeto())+1);
		size++;
	}
	
	public void añadirPropiedad(String propiedad){
		if(propiedad.equals("<http://www.w3.org/1999/02/22-rdf-syntax-ns#type>"))
			aristas.put(propiedad,"es");
		else if(propiedad.equals("<http://www.w3.org/2000/01/rdf-schema#subClassOf>"))
			aristas.put(propiedad,"subClaseDe");
		else if(propiedad.equals("<http://www.lehigh.edu/~zhp2/2004/0401/univ-bench.owl#takesCourse>"))
			aristas.put(propiedad,"cursa");
		else if(propiedad.equals("<http://www.lehigh.edu/~zhp2/2004/0401/univ-bench.owl#teacherOf>"))
			aristas.put(propiedad,"encargadoDe");
		else if(propiedad.equals("<http://www.lehigh.edu/~zhp2/2004/0401/univ-bench.owl#subOrganizationOf>"))
			aristas.put(propiedad,"departamentoDe");
		else if(propiedad.equals("<http://www.lehigh.edu/~zhp2/2004/0401/univ-bench.owl#worksFor>"))
			aristas.put(propiedad,"trabajaPara");
		else 
			aristas.put(propiedad, propiedad);
	}
	
	//METODO 1
	public Almacen sentenciasConSujeto(String sujeto)
	{
		if(!this.grafo.contains(sujeto)) return new Almacen();
		Almacen alm = new Almacen();
		Enumeration<String> propiedades = grafo.get(sujeto).get(0).keys();
		Enumeration<String> objetos;
		String propiedad, objeto;
		int i, repeticiones;
		while(propiedades.hasMoreElements())
		{
			propiedad = propiedades.nextElement();
			objetos = grafo.get(sujeto).get(0).get(propiedad).keys();
			while(objetos.hasMoreElements())
			{
				i = 1;
				objeto = objetos.nextElement();
				repeticiones = grafo.get(sujeto).get(0).get(propiedad).get(objeto);
				while(i<=repeticiones)
				{
					alm.añadirElemento(new Sentencia(sujeto,propiedad,objeto));
					i++;
				}
			}
		}
		return alm;
	}
	
	//METODO 2
	public Almacen sentenciasSinRepConSujeto(String sujeto)
	{
		if(!this.grafo.contains(sujeto)) return new Almacen();
		Almacen alm = new Almacen();
		Enumeration<String> propiedades = grafo.get(sujeto).get(0).keys();
		Enumeration<String> objetos;
		String propiedad;
		while(propiedades.hasMoreElements())
		{
			propiedad = propiedades.nextElement();
			objetos = grafo.get(sujeto).get(0).get(propiedad).keys();
			while(objetos.hasMoreElements())
			{
				alm.añadirElemento(new Sentencia(sujeto,propiedad,objetos.nextElement()));
			}
		}
		return alm;
	}
	
	//METODO 3
	public AlmacenEntidades propiedadesDistintas()
	{
		if(this.grafo.isEmpty()) return new AlmacenEntidades();
		AlmacenEntidades alm = new AlmacenEntidades();
		Enumeration<String> propiedades = this.aristas.keys();
		while(propiedades.hasMoreElements())
		{
			alm.añadirElemento(propiedades.nextElement());
		}
		return alm;
	}
	
	//METODO 4
	public AlmacenEntidades sujetoYObjeto()
	{
		if(this.grafo.isEmpty()) return new AlmacenEntidades();
		String sujeto;
		Enumeration<String> sujetos = grafo.keys();
		AlmacenEntidades alm = new AlmacenEntidades();
		while(sujetos.hasMoreElements())
		{
			sujeto = sujetos.nextElement();
			if (!grafo.get(sujeto).get(0).isEmpty() && !grafo.get(sujeto).get(1).isEmpty())
				alm.añadirElemento(sujeto);
		}
		return alm;
	}
	
	//METODO 6
	public LinkedOrderList<Sentencia> ordenar()
	{
		if(grafo.isEmpty()) return new LinkedOrderList<Sentencia>();
		LinkedOrderList<Sentencia> lista = new LinkedOrderList<Sentencia>();
		Enumeration<String> sujetos,propiedades,objetos;
		Enumeration<Integer> repeticiones;
		sujetos = grafo.keys();
		String sujeto, propiedad, objeto;
		int i, j;
		while(sujetos.hasMoreElements())
		{
			sujeto = sujetos.nextElement();
			propiedades = grafo.get(sujeto).get(0).keys();
			while(propiedades.hasMoreElements())
			{
				propiedad = propiedades.nextElement();
				objetos = grafo.get(sujeto).get(0).get(propiedad).keys();
				repeticiones = grafo.get(sujeto).get(0).get(propiedad).elements();
				while(objetos.hasMoreElements())
				{
					i = repeticiones.nextElement();
					j = 1;
					objeto = objetos.nextElement();
					while(j<=i)
					{
						lista.add(new Sentencia(sujeto, propiedad, objeto));
						j++;
						
					}
				}
			}
		}
		return lista;
	}
	
	// METODO 7A
	public AlmacenEntidades clasesDeSujeto(String sujeto)
	{
		if(this.grafo.isEmpty()) return new AlmacenEntidades();
		AlmacenEntidades alm = new AlmacenEntidades();
		if(grafo.containsKey(sujeto) && grafo.get(sujeto).get(0).containsKey("<http://www.w3.org/1999/02/22-rdf-syntax-ns#type>"))
		{
			Enumeration<String> clases = grafo.get(sujeto).get(0).get("<http://www.w3.org/1999/02/22-rdf-syntax-ns#type>").keys();
			while(clases.hasMoreElements())
				alm.añadirElemento(clases.nextElement());
		}
		return alm;
	}
	
	// METODO 7B
	public AlmacenEntidades superClases(String clase)
	{
		if(this.grafo.isEmpty()) return new AlmacenEntidades();
		AlmacenEntidades alm = new AlmacenEntidades();
		alm.añadirElemento(clase);
		if(grafo.contains(clase) && grafo.get(clase).get(0).containsKey("<http://www.w3.org/2000/01/rdf-schema#subClassOf>"))
			alm = superClases(clase,alm);
		return alm;			
	}
	
	// METODO 7B
	private AlmacenEntidades superClases(String clase,AlmacenEntidades alm)
	{
		String aux;
		Enumeration<String> clases = grafo.get(clase).get(0).get("<http://www.w3.org/1999/02/22-rdf-syntax-ns#type>").keys();
		while(clases.hasMoreElements())
		{
			aux = clases.nextElement();
			alm.añadirElemento(aux);
			if(grafo.contains(aux) && grafo.get(aux).get(0).containsKey("<http://www.w3.org/2000/01/rdf-schema#subClassOf>"))
				alm = superClases(aux,alm);				
		}
		return alm;
	}
	
	// METODO 8
	public AlmacenEntidades entidadesDeClase(String clase)
	{
		if(this.grafo.isEmpty()) return new AlmacenEntidades();
		AlmacenEntidades alm = new AlmacenEntidades();
		Enumeration<String> entidades = grafo.get(clase).get(1).get("<http://www.w3.org/1999/02/22-rdf-syntax-ns#type>").keys();
		while(entidades.hasMoreElements())
			alm.añadirElemento(entidades.nextElement());
		return alm;
	}
	
	// METODO 9A
	public Almacen cargar(String nombreDeArchivo)
	{
		Almacen alm=new Almacen();
		String sujeto, propiedad, objeto;
		try
		{
			Scanner consola = new Scanner(new File("src/"+nombreDeArchivo));
			while(consola.hasNext())
			{
				sujeto = consola.next();
				propiedad = consola.next();
				objeto = consola.next();
				consola.nextLine();
				alm.añadirElemento(new Sentencia(sujeto, propiedad, objeto));
				alm.añadirPropiedad(propiedad);
			}
			consola.close();
		} catch (FileNotFoundException e)
		{
			System.out.println("El nombre del archivo es incorrecto.");
		}
		return alm;
	}
	
	// METODO 9B
	public void descargar(String nombreDeArchivo) throws IOException
	{
		if(this.grafo.isEmpty())
		{
			System.out.println("El almacen esta vacio.");
			return;
		}
		try
		{
			BufferedWriter output = new BufferedWriter(new FileWriter("src/"+nombreDeArchivo));
			Enumeration<String> sujetos = grafo.keys();
			Enumeration<String> propiedades;
			Enumeration<String> objetos;
			String sujeto, propiedad,objeto;
			int j = 0;
			while(sujetos.hasMoreElements())
			{
				sujeto = sujetos.nextElement();
				propiedades = grafo.get(sujeto).get(0).keys();
				while(propiedades.hasMoreElements())
				{ 
					propiedad = propiedades.nextElement();
					objetos = grafo.get(sujeto).get(0).get(propiedad).keys();
					while(objetos.hasMoreElements())
					{	
						objeto = objetos.nextElement();				
						for (int i=0; i<grafo.get(sujeto).get(0).get(propiedad).get(objeto);i++)
						{
							output.write(j+"--> "+sujeto + " " + propiedad + " " + objeto + " .\n");
							j++;
						}
					}
				}
			}
			output.close();
		} catch (FileNotFoundException e)
		{
			System.out.println("El nombre del archivo es incorrecto.");
		}
	}
	
	// METODO 10
	public AlmacenEntidades estudiantesDeProfesor(String profesor)
	{
		if(this.grafo.isEmpty()) return new AlmacenEntidades();
		AlmacenEntidades alm = new AlmacenEntidades();
		Enumeration<String> alumnos;
		String asignatura;
		if(grafo.containsKey(profesor))
		{
			Enumeration<String> asignaturas = grafo.get(profesor).get(0).get("<http://www.lehigh.edu/~zhp2/2004/0401/univ-bench.owl#teacherOf>").keys();
			while(asignaturas.hasMoreElements())
			{
				asignatura = asignaturas.nextElement();
				if(grafo.get(asignatura).get(1).containsKey("<http://www.lehigh.edu/~zhp2/2004/0401/univ-bench.owl#takesCourse>"))
				{
					alumnos = grafo.get(asignatura).get(1).get("<http://www.lehigh.edu/~zhp2/2004/0401/univ-bench.owl#takesCourse>").keys();
					while(alumnos.hasMoreElements())
						alm.añadirElemento(alumnos.nextElement());
				}
			}
		}
		return alm;
	}
	
	// METODO 11
	public AlmacenEntidades profesoresDeUniversidad(String universidad)
	{
		if(this.grafo.isEmpty()) return new AlmacenEntidades();
		String departamento;
		AlmacenEntidades alm = new AlmacenEntidades();
		Enumeration<String> profesores;
		if(grafo.containsKey(universidad))
		{
			Enumeration<String> departamentos = grafo.get(universidad).get(1).get("<http://www.lehigh.edu/~zhp2/2004/0401/univ-bench.owl#subOrganizationOf>").keys();
			while(departamentos.hasMoreElements())
			{
				departamento = departamentos.nextElement();
				if (grafo.get(departamento).get(1).containsKey("<http://www.lehigh.edu/~zhp2/2004/0401/univ-bench.owl#worksFor>"))
				{
					profesores = grafo.get(departamento).get(1).get("<http://www.lehigh.edu/~zhp2/2004/0401/univ-bench.owl#worksFor>").keys();
					while(profesores.hasMoreElements())
						alm.añadirElemento(profesores.nextElement());
				}
			}
		}
		return alm;
	}
	
	public void imprimir()
	{
		if(this.grafo.isEmpty())
		{
			System.out.println("El almacen esta vacio.");
			return;
		}
		Enumeration<String> sujetos,propiedades,objetos;
		Enumeration<Integer> repeticiones;
		sujetos = grafo.keys();
		String sujeto, propiedad, objeto;
		int i, j, cont = 0;
		while(sujetos.hasMoreElements())
		{
			sujeto = sujetos.nextElement();
			propiedades = grafo.get(sujeto).get(0).keys();
			while(propiedades.hasMoreElements())
			{
				propiedad = propiedades.nextElement();
				objetos = grafo.get(sujeto).get(0).get(propiedad).keys();
				repeticiones = grafo.get(sujeto).get(0).get(propiedad).elements();
				while(objetos.hasMoreElements())
				{
					i = repeticiones.nextElement();
					j = 1;
					objeto = objetos.nextElement();
					while(j<=i)
					{
						System.out.println(cont +  "=> " + sujeto + " " + propiedad + " " + objeto + " .");
						j++;
						cont++;
					}
				}
			}
		}
	}
	
}
