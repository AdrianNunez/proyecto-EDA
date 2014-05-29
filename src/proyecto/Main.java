package proyecto;

import java.io.IOException;
import java.util.Scanner;

import listas.LinkedOrderList;

public class Main
{
	public static void main(String[] args) throws IOException
	{
		Almacen A1 =new Almacen();
		Almacen A2 =new Almacen();
		Almacen A3 =new Almacen();
		Almacen A4 =new Almacen();
		Almacen A5 =new Almacen();
		Almacen A6 =new Almacen();
		Almacen Aux = new Almacen();
		
		LinkedOrderList<Sentencia> lista = new LinkedOrderList<Sentencia>();
		
		AlmacenEntidades B1 =new AlmacenEntidades();
		
		AlmacenDeAlmacenes C1 = new AlmacenDeAlmacenes();
		
		///////////////// PROCESO DE CARGA ////////////////
		
		long tiempoInicio = System.currentTimeMillis();
		System.out.print("Cargando almacenes... |");
		A1 = A1.cargar("extractoDatosUniv.txt");
		System.out.print("=");
		A2 = A2.cargar("datosUniversidad1.txt");
		System.out.print("=");
		A3 = A3.cargar("datosUniversidad9.txt");
		System.out.print("=");
		A4 = A4.cargar("datosUniversidad19.txt");
		System.out.print("=");
		A5 = A5.cargar("datosUniversidad39.txt");
		System.out.print("=");
		A6 = A6.cargar("datosUniversidad99.txt");
		System.out.print("=| \r");
		System.out.println("Almacenes cargados con total Exito");
		long totalTiempo = System.currentTimeMillis() - tiempoInicio;
		System.out.println("El tiempo para cargar es "
		 + totalTiempo/1000 + " segundos");
		
		//////////////////////////////////////////////////////////////////////////////////////
		
		boolean salir = false;
		boolean correcto = false;
		Scanner consola = new Scanner(System.in);
		int metodo;
		int almacen,numAlmacenes;
		String sujeto,clase,nombreDeArchivo,profesor,universidad;
		
		while(!salir){
			
                                    ////////////////MENU /////////////////
			System.out.println("A continuacion se mostraran los metodos que se podran aplicar sobre los almacenes.");
			System.out.println("Elige uno de los siguientes metodos: ");
			System.out.println("1 ---> (1)Sentencias con el mismo sujeto, dado por parametro");
			System.out.println("2 ---> (2)Sentencias con el mismo sujeto, dado por parametro y distintas");
			System.out.println("3 ---> (3)Coleccion de propiedades distintas");
			System.out.println("4 ---> (4)Coleccion de entidades distintas que son sujeto y objeto");
			System.out.println("5 ---> (5)Coleccion de entidades distintas que son sujetos en todos y cada uno de esos almacenes.");
			System.out.println("6 ---> (6)Coleccion ordenada de todas las sentencias que aparecen en el almacen.");
			System.out.println("7 ---> (7a)Coleccion de las clases de un sujeto, dado como parametro, enese almacen.");
			System.out.println("8 ---> (7b)Coleccion de las clases que son superclase de una clase, dadacomo parametro, en ese almacen.");
			System.out.println("9 ---> (8)Coleccion de entidades que son de una determinada clase, dada como parametro, en ese almacen");
			System.out.println("10 ---> (9b)Descargar las sentencias de un almacen en un archivo de texto de nuestro directorio.");
			System.out.println("11 ---> (10)Coleccion de estudiantes distintos que cursan alguna asignatura dela que es encargado un determinado profesor, dado como parametro.");
			System.out.println("12 ---> (11)Coleccion de profesores distintos que trabajan para algun departamento de una universidad, dada como parametro.");
			System.out.println("0 ---> Salir");
			
			metodo = consola.nextInt();
			if (metodo == 1){ //--------> Metodo 1
				System.out.println("Elige el almacen con el que quieres ejecutar el metodo(0|1|9|19|39|99)");
				correcto = false;
				while(!correcto){
					almacen = consola.nextInt();
				if (almacen == 0){
					System.out.println("Introduce el sujeto con el que ejecutar el metodo");
					sujeto = consola.next();
					tiempoInicio = System.currentTimeMillis();
					Aux = A1.sentenciasConSujeto(sujeto);
					totalTiempo = System.currentTimeMillis() - tiempoInicio;
					System.out.println("El tiempo para el metodo "
					 + totalTiempo + " milisegundos");
				}else if (almacen == 1){
					System.out.println("Introduce el sujeto con el que ejecutar el metodo");
					sujeto = consola.next();
					tiempoInicio = System.currentTimeMillis();
					Aux = A2.sentenciasConSujeto(sujeto);
					totalTiempo = System.currentTimeMillis() - tiempoInicio;
					System.out.println("El tiempo para el metodo "
					 + totalTiempo + " milisegundos");
				}else if (almacen == 9){
					System.out.println("Introduce el sujeto con el que ejecutar el metodo");
					sujeto = consola.next();
					tiempoInicio = System.currentTimeMillis();
					Aux = A3.sentenciasConSujeto(sujeto);
					totalTiempo = System.currentTimeMillis() - tiempoInicio;
					System.out.println("El tiempo para el metodo "
					 + totalTiempo + " milisegundos");
				}else if (almacen == 19){
					System.out.println("Introduce el sujeto con el que ejecutar el metodo");
					sujeto = consola.next();
					tiempoInicio = System.currentTimeMillis();
					Aux = A4.sentenciasConSujeto(sujeto);
					totalTiempo = System.currentTimeMillis() - tiempoInicio;
					System.out.println("El tiempo para el metodo "
					 + totalTiempo + " milisegundos");
				}else if (almacen == 39){
					System.out.println("Introduce el sujeto con el que ejecutar el metodo");
					sujeto = consola.next();
					tiempoInicio = System.currentTimeMillis();
					Aux = A5.sentenciasConSujeto(sujeto);
					totalTiempo = System.currentTimeMillis() - tiempoInicio;
					System.out.println("El tiempo para el metodo "
					 + totalTiempo + " milisegundos");
				}else if (almacen == 99){
					System.out.println("Introduce el sujeto con el que ejecutar el metodo");
					sujeto = consola.next();
					tiempoInicio = System.currentTimeMillis();
					Aux = A6.sentenciasConSujeto(sujeto);
					totalTiempo = System.currentTimeMillis() - tiempoInicio;
					System.out.println("El tiempo para el metodo "
					 + totalTiempo + " milisegundos");
				}else {
					System.out.println("El almacen introducido no es correcto, por favor elige entre (0|1|9|19|39|99)");
				}
				}
				Aux.clear();
			}else if (metodo == 2){ //--------> Metodo 2
				System.out.println("Elige el almacen con el que quieres ejecutar el metodo(0|1|9|19|39|99)");
				correcto = false;
				while(!correcto){
					almacen = consola.nextInt();
				if (almacen == 0){
					System.out.println("Introduce el sujeto con el que ejecutar el metodo");
					sujeto = consola.next();
					tiempoInicio = System.currentTimeMillis();
					Aux = A1.sentenciasSinRepConSujeto(sujeto);
					totalTiempo = System.currentTimeMillis() - tiempoInicio;
					System.out.println("El tiempo para el metodo "
					 + totalTiempo + " milisegundos");
					correcto = true;
				}else if (almacen == 1){
					System.out.println("Introduce el sujeto con el que ejecutar el metodo");
					sujeto = consola.next();
					tiempoInicio = System.currentTimeMillis();
					Aux = A2.sentenciasSinRepConSujeto(sujeto);
					totalTiempo = System.currentTimeMillis() - tiempoInicio;
					System.out.println("El tiempo para el metodo "
					 + totalTiempo + " milisegundos");
					correcto = true;
				}else if (almacen == 9){
					System.out.println("Introduce el sujeto con el que ejecutar el metodo");
					sujeto = consola.next();
					tiempoInicio = System.currentTimeMillis();
					Aux = A3.sentenciasSinRepConSujeto(sujeto);
					totalTiempo = System.currentTimeMillis() - tiempoInicio;
					System.out.println("El tiempo para el metodo "
					 + totalTiempo + " milisegundos");
					correcto = true;
				}else if (almacen == 19){
					System.out.println("Introduce el sujeto con el que ejecutar el metodo");
					sujeto = consola.next();
					tiempoInicio = System.currentTimeMillis();
					Aux = A4.sentenciasSinRepConSujeto(sujeto);
					totalTiempo = System.currentTimeMillis() - tiempoInicio;
					System.out.println("El tiempo para el metodo "
					 + totalTiempo + " milisegundos");
					correcto = true;
				}else if (almacen == 39){
					System.out.println("Introduce el sujeto con el que ejecutar el metodo");
					sujeto = consola.next();
					tiempoInicio = System.currentTimeMillis();
					Aux = A5.sentenciasSinRepConSujeto(sujeto);
					totalTiempo = System.currentTimeMillis() - tiempoInicio;
					System.out.println("El tiempo para el metodo "
					 + totalTiempo + " milisegundos");
					correcto = true;
				}else if (almacen == 99){
					System.out.println("Introduce el sujeto con el que ejecutar el metodo");
					sujeto = consola.next();
					tiempoInicio = System.currentTimeMillis();
					Aux = A6.sentenciasSinRepConSujeto(sujeto);
					totalTiempo = System.currentTimeMillis() - tiempoInicio;
					System.out.println("El tiempo para el metodo "
					 + totalTiempo + " milisegundos");
					correcto = true;
				}else {
					System.out.println("El almacen introducido no es correcto, por favor elige entre (0|1|9|19|39|99)");
				}
				}
				Aux.clear();
			}else if (metodo == 3){ //--------> Metodo 3
				System.out.println("Elige el almacen con el que quieres ejecutar el metodo(0|1|9|19|39|99)");
				correcto = false;
				while(!correcto){
					almacen = consola.nextInt();
				if (almacen == 0){ 
					tiempoInicio = System.currentTimeMillis();
					B1 = A1.propiedadesDistintas();
					totalTiempo = System.currentTimeMillis() - tiempoInicio;
					System.out.println("El tiempo para el metodo "
					 + totalTiempo + " milisegundos");
					correcto=true;
				}else if (almacen == 1){
					tiempoInicio = System.currentTimeMillis();
					B1 = A2.propiedadesDistintas();
					totalTiempo = System.currentTimeMillis() - tiempoInicio;
					System.out.println("El tiempo para el metodo "
					 + totalTiempo + " milisegundos");
					correcto=true;
				}else if (almacen == 9){
					tiempoInicio = System.currentTimeMillis();
					B1 = A3.propiedadesDistintas();
					totalTiempo = System.currentTimeMillis() - tiempoInicio;
					System.out.println("El tiempo para el metodo "
					 + totalTiempo + " milisegundos");
					correcto=true;
				}else if (almacen == 19){
					tiempoInicio = System.currentTimeMillis();
					B1 = A4.propiedadesDistintas();
					totalTiempo = System.currentTimeMillis() - tiempoInicio;
					System.out.println("El tiempo para el metodo "
					 + totalTiempo + " milisegundos");
					correcto=true;
				}else if (almacen == 39){
					tiempoInicio = System.currentTimeMillis();
					B1 = A5.propiedadesDistintas();
					totalTiempo = System.currentTimeMillis() - tiempoInicio;
					System.out.println("El tiempo para el metodo "
					 + totalTiempo + " milisegundos");
					correcto=true;
				}else if (almacen == 99){
					tiempoInicio = System.currentTimeMillis();
					B1 = A6.propiedadesDistintas();
					totalTiempo = System.currentTimeMillis() - tiempoInicio;
					System.out.println("El tiempo para el metodo "
					 + totalTiempo + " milisegundos");
					correcto=true;
				}else {
					System.out.println("El almacen introducido no es correcto, por favor elige entre (0|1|9|19|39|99)");
				}
				}
				B1.clear();
			}else if (metodo == 4){ //--------> Metodo 4
				System.out.println("Elige el almacen con el que quieres ejecutar el metodo(0|1|9|19|39|99)");
				correcto = false;
				while(!correcto){
					almacen = consola.nextInt();
				if (almacen == 0){
					tiempoInicio = System.currentTimeMillis();
					B1 = A1.sujetoYObjeto();
					totalTiempo = System.currentTimeMillis() - tiempoInicio;
					System.out.println("El tiempo para el metodo "
					 + totalTiempo + " milisegundos");
					correcto = true;
				}else if (almacen == 1){
					tiempoInicio = System.currentTimeMillis();
					B1 = A2.sujetoYObjeto();
					totalTiempo = System.currentTimeMillis() - tiempoInicio;
					System.out.println("El tiempo para el metodo "
					 + totalTiempo + " milisegundos");
					correcto = true;
				}else if (almacen == 9){
					tiempoInicio = System.currentTimeMillis();
					B1 = A3.sujetoYObjeto();
					totalTiempo = System.currentTimeMillis() - tiempoInicio;
					System.out.println("El tiempo para el metodo "
					 + totalTiempo + " milisegundos");
					correcto = true;
				}else if (almacen == 19){
					tiempoInicio = System.currentTimeMillis();
					B1 = A4.sujetoYObjeto();
					totalTiempo = System.currentTimeMillis() - tiempoInicio;
					System.out.println("El tiempo para el metodo "
					 + totalTiempo + " milisegundos");
					correcto = true;
				}else if (almacen == 39){
					tiempoInicio = System.currentTimeMillis();
					B1 = A5.sujetoYObjeto();
					totalTiempo = System.currentTimeMillis() - tiempoInicio;
					System.out.println("El tiempo para el metodo "
					 + totalTiempo + " milisegundos");
					correcto = true;
				}else if (almacen == 99){
					tiempoInicio = System.currentTimeMillis();
					B1 = A6.sujetoYObjeto();
					totalTiempo = System.currentTimeMillis() - tiempoInicio;
					System.out.println("El tiempo para el metodo "
					 + totalTiempo + " milisegundos");
					correcto = true;
				}else {
					System.out.println("El almacen introducido no es correcto, por favor elige entre (0|1|9|19|39|99)");
				}
				}
				B1.clear();
			}else if (metodo == 5){ //-------> Metodo 5
				System.out.println("¿Con cuantos almacenes quieres hacer la prueba de interseccion?");
				numAlmacenes = consola.nextInt();
				int i = 0;
				while (i<numAlmacenes){
					System.out.print("Almacen "+(i+1)+" que desea introdudir al almacen de almacenes (0|1|9|19|39|99)");
					almacen = consola.nextInt();
					if(almacen == 0){
						C1.añadirAlmacen(A1);
						i++;
					}else if(almacen == 1){
						C1.añadirAlmacen(A2);
						i++;
					}else if(almacen == 9){
						C1.añadirAlmacen(A3);
						i++;
					}else if(almacen == 19){
						C1.añadirAlmacen(A4);
						i++;
					}else if(almacen == 39){
						C1.añadirAlmacen(A5);
						i++;
					}else if(almacen == 99){
						C1.añadirAlmacen(A6);
						i++;
					}else {
						System.out.println("El almacen introducido no existe, Porfavor introduzca de nuevo un almacen");
					}
					
				}
				tiempoInicio = System.currentTimeMillis();
				B1 = C1.interseccion();
				totalTiempo = System.currentTimeMillis() - tiempoInicio;
				System.out.println("El tiempo para el metodo "
				 + totalTiempo + " milisegundos");
				B1.clear();
				C1.clear();
			}else if(metodo == 6){ //--------> Metodo 6
				System.out.println("Elige el almacen con el que quieres ejecutar el metodo(0|1|9|19|39|99)");
				correcto = false;
				while(!correcto){
				almacen = consola.nextInt();
				if (almacen == 0){
					tiempoInicio = System.currentTimeMillis();
					lista = A1.ordenar();
					totalTiempo = System.currentTimeMillis() - tiempoInicio;
					System.out.println("El tiempo para el metodo "
					 + totalTiempo + " milisegundos");
					correcto = true;
				}else if (almacen == 1){
					tiempoInicio = System.currentTimeMillis();
					lista = A2.ordenar();
					totalTiempo = System.currentTimeMillis() - tiempoInicio;
					System.out.println("El tiempo para el metodo "
					 + totalTiempo + " milisegundos");
					correcto = true;
				}else if (almacen == 9){
					tiempoInicio = System.currentTimeMillis();
					lista = A3.ordenar();
					totalTiempo = System.currentTimeMillis() - tiempoInicio;
					System.out.println("El tiempo para el metodo "
					 + totalTiempo + " milisegundos");
					correcto = true;
				}else if (almacen == 19){
					tiempoInicio = System.currentTimeMillis();
					lista = A4.ordenar();
					totalTiempo = System.currentTimeMillis() - tiempoInicio;
					System.out.println("El tiempo para el metodo "
					 + totalTiempo + " milisegundos");
					correcto = true;
				}else if (almacen == 39){
					tiempoInicio = System.currentTimeMillis();
					lista = A5.ordenar();
					totalTiempo = System.currentTimeMillis() - tiempoInicio;
					System.out.println("El tiempo para el metodo "
					 + totalTiempo + " milisegundos");
					correcto = true;
				}else if (almacen == 99){
					tiempoInicio = System.currentTimeMillis();
					lista = A6.ordenar();
					totalTiempo = System.currentTimeMillis() - tiempoInicio;
					System.out.println("El tiempo para el metodo "
					 + totalTiempo + " milisegundos");
					correcto = true;
				}else {
					System.out.println("El almacen introducido no es correcto, por favor elige entre (0|1|9|19|39|99)");
				}
				}
				lista.clear();
			}else if (metodo == 7){ // Metodo 7a
				System.out.println("Elige el almacen con el que quieres ejecutar el metodo(0|1|9|19|39|99)");
				correcto = false;
				while(!correcto){
				almacen = consola.nextInt();
				if (almacen == 0){
					System.out.println("Introduce el sujeto con el que ejecutar el metodo");
					sujeto = consola.next();
					tiempoInicio = System.currentTimeMillis();
					B1 = A1.clasesDeSujeto(sujeto);
					totalTiempo = System.currentTimeMillis() - tiempoInicio;
					System.out.println("El tiempo para el metodo "
					 + totalTiempo + " milisegundos");
					correcto = true;
				}else if (almacen == 1){
					System.out.println("Introduce el sujeto con el que ejecutar el metodo");
					sujeto = consola.next();
					tiempoInicio = System.currentTimeMillis();
					B1 = A2.clasesDeSujeto(sujeto);
					totalTiempo = System.currentTimeMillis() - tiempoInicio;
					System.out.println("El tiempo para el metodo "
					 + totalTiempo + " milisegundos");
					correcto = true;
				}else if (almacen == 9){
					System.out.println("Introduce el sujeto con el que ejecutar el metodo");
					sujeto = consola.next();
					tiempoInicio = System.currentTimeMillis();
					B1 = A3.clasesDeSujeto(sujeto);
					totalTiempo = System.currentTimeMillis() - tiempoInicio;
					System.out.println("El tiempo para el metodo "
					 + totalTiempo + " milisegundos");
					correcto = true;
				}else if (almacen == 19){
					System.out.println("Introduce el sujeto con el que ejecutar el metodo");
					sujeto = consola.next();
					tiempoInicio = System.currentTimeMillis();
					B1 = A4.clasesDeSujeto(sujeto);
					totalTiempo = System.currentTimeMillis() - tiempoInicio;
					System.out.println("El tiempo para el metodo "
					 + totalTiempo + " milisegundos");
					correcto = true;
				}else if (almacen == 39){
					System.out.println("Introduce el sujeto con el que ejecutar el metodo");
					sujeto = consola.next();
					tiempoInicio = System.currentTimeMillis();
					B1 = A5.clasesDeSujeto(sujeto);
					totalTiempo = System.currentTimeMillis() - tiempoInicio;
					System.out.println("El tiempo para el metodo "
					 + totalTiempo + " milisegundos");
					correcto = true;
				}else if (almacen == 99){
					System.out.println("Introduce el sujeto con el que ejecutar el metodo");
					sujeto = consola.next();
					tiempoInicio = System.currentTimeMillis();
					B1 = A6.clasesDeSujeto(sujeto);
					totalTiempo = System.currentTimeMillis() - tiempoInicio;
					System.out.println("El tiempo para el metodo "
					 + totalTiempo + " milisegundos");
					correcto = true;
				}else {
					System.out.println("El almacen introducido no es correcto, por favor elige entre (0|1|9|19|39|99)");
				}
				}
				B1.clear();
			}else if(metodo == 8){ // Metodo 7b
				System.out.println("Elige el almacen con el que quieres ejecutar el metodo(0|1|9|19|39|99)");
				correcto = false;
				while(!correcto){
				almacen = consola.nextInt();
				if (almacen == 0){
					System.out.println("Introduce la clase con el que ejecutar el metodo");
					clase = consola.next();
					tiempoInicio = System.currentTimeMillis();
					B1 = A1.superClases(clase);
					totalTiempo = System.currentTimeMillis() - tiempoInicio;
					System.out.println("El tiempo para el metodo "
					 + totalTiempo + " milisegundos");
					correcto = true;
				}else if (almacen == 1){
					System.out.println("Introduce la clase con el que ejecutar el metodo");
					clase = consola.next();
					tiempoInicio = System.currentTimeMillis();
					B1 = A2.superClases(clase);
					totalTiempo = System.currentTimeMillis() - tiempoInicio;
					System.out.println("El tiempo para el metodo "
					 + totalTiempo + " milisegundos");
					correcto = true;
				}else if (almacen == 9){
					System.out.println("Introduce la clase con el que ejecutar el metodo");
					clase = consola.next();
					tiempoInicio = System.currentTimeMillis();
					B1 = A3.superClases(clase);
					totalTiempo = System.currentTimeMillis() - tiempoInicio;
					System.out.println("El tiempo para el metodo "
					 + totalTiempo + " milisegundos");
					correcto = true;
				}else if (almacen == 19){
					System.out.println("Introduce la clase con el que ejecutar el metodo");
					clase = consola.next();
					tiempoInicio = System.currentTimeMillis();
					B1 = A4.superClases(clase);
					totalTiempo = System.currentTimeMillis() - tiempoInicio;
					System.out.println("El tiempo para el metodo "
					 + totalTiempo + " milisegundos");
					correcto = true;
				}else if (almacen == 39){
					System.out.println("Introduce la clase con el que ejecutar el metodo");
					clase = consola.next();
					tiempoInicio = System.currentTimeMillis();
					B1 = A5.superClases(clase);
					totalTiempo = System.currentTimeMillis() - tiempoInicio;
					System.out.println("El tiempo para el metodo "
					 + totalTiempo + " milisegundos");
					correcto = true;
				}else if (almacen == 99){
					System.out.println("Introduce la clase con el que ejecutar el metodo");
					clase = consola.next();
					tiempoInicio = System.currentTimeMillis();
					B1 = A6.superClases(clase);
					totalTiempo = System.currentTimeMillis() - tiempoInicio;
					System.out.println("El tiempo para el metodo "
					 + totalTiempo + " milisegundos");
					correcto = true;
				}else {
					System.out.println("El almacen introducido no es correcto, por favor elige entre (0|1|9|19|39|99)");
				}
				}
				B1.clear();
			}else if (metodo == 9){ //Metodo 8
				System.out.println("Elige el almacen con el que quieres ejecutar el metodo(0|1|9|19|39|99)");
				correcto = false;
				while(!correcto){
				almacen = consola.nextInt();
				if (almacen == 0){
					System.out.println("Introduce la clase con el que ejecutar el metodo");
					clase = consola.next();
					tiempoInicio = System.currentTimeMillis();
					B1 = A1.entidadesDeClase(clase);
					totalTiempo = System.currentTimeMillis() - tiempoInicio;
					System.out.println("El tiempo para el metodo "
					 + totalTiempo + " milisegundos");
					correcto = true;
				}else if (almacen == 1){
					System.out.println("Introduce la clase con el que ejecutar el metodo");
					clase = consola.next();
					tiempoInicio = System.currentTimeMillis();
					B1 = A2.entidadesDeClase(clase);
					totalTiempo = System.currentTimeMillis() - tiempoInicio;
					System.out.println("El tiempo para el metodo "
					 + totalTiempo + " milisegundos");
					correcto = true;
				}else if (almacen == 9){
					System.out.println("Introduce la clase con el que ejecutar el metodo");
					clase = consola.next();
					tiempoInicio = System.currentTimeMillis();
					B1 = A3.entidadesDeClase(clase);
					totalTiempo = System.currentTimeMillis() - tiempoInicio;
					System.out.println("El tiempo para el metodo "
					 + totalTiempo + " milisegundos");
					correcto = true;
				}else if (almacen == 19){
					System.out.println("Introduce la clase con el que ejecutar el metodo");
					clase = consola.next();
					tiempoInicio = System.currentTimeMillis();
					B1 = A4.entidadesDeClase(clase);
					totalTiempo = System.currentTimeMillis() - tiempoInicio;
					System.out.println("El tiempo para el metodo "
					 + totalTiempo + " milisegundos");
					correcto = true;
				}else if (almacen == 39){
					System.out.println("Introduce la clase con el que ejecutar el metodo");
					clase = consola.next();
					tiempoInicio = System.currentTimeMillis();
					B1 = A5.entidadesDeClase(clase);
					totalTiempo = System.currentTimeMillis() - tiempoInicio;
					System.out.println("El tiempo para el metodo "
					 + totalTiempo + " milisegundos");
					correcto = true;
				}else if (almacen == 99){
					System.out.println("Introduce la clase con el que ejecutar el metodo");
					clase = consola.next();
					tiempoInicio = System.currentTimeMillis();
					B1 = A6.entidadesDeClase(clase);
					totalTiempo = System.currentTimeMillis() - tiempoInicio;
					System.out.println("El tiempo para el metodo "
					 + totalTiempo + " milisegundos");
					correcto = true;
				}else {
					System.out.println("El almacen introducido no es correcto, por favor elige entre (0|1|9|19|39|99)");
				}
				}
				B1.clear();
			}else if (metodo == 10){ //Metodo 9
				System.out.println("Elige el almacen con el que quieres ejecutar el metodo(0|1|9|19|39|99)");
				correcto = false;
				while(!correcto){
				almacen = consola.nextInt();
				if (almacen == 0){
					System.out.println("Introduce el nombre del archivo en el que deseas descargar el almacen EJ: Almacen.txt ");
					nombreDeArchivo = consola.next();
					tiempoInicio = System.currentTimeMillis();
					A1.descargar(nombreDeArchivo);
					totalTiempo = System.currentTimeMillis() - tiempoInicio;
					System.out.println("El tiempo para el metodo "
					 + totalTiempo + " milisegundos");
					correcto = true;
				}else if (almacen == 1){
					System.out.println("Introduce el nombre del archivo en el que deseas descargar el almacen EJ: Almacen.txt ");
					nombreDeArchivo = consola.next();
					tiempoInicio = System.currentTimeMillis();
					A2.descargar(nombreDeArchivo);
					totalTiempo = System.currentTimeMillis() - tiempoInicio;
					System.out.println("El tiempo para el metodo "
					 + totalTiempo + " milisegundos");
					correcto = true;
				}else if (almacen == 9){
					System.out.println("Introduce el nombre del archivo en el que deseas descargar el almacen EJ: Almacen.txt ");
					nombreDeArchivo = consola.next();
					tiempoInicio = System.currentTimeMillis();
					A3.descargar(nombreDeArchivo);
					totalTiempo = System.currentTimeMillis() - tiempoInicio;
					System.out.println("El tiempo para el metodo "
					 + totalTiempo + " milisegundos");
					correcto = true;
				}else if (almacen == 19){
					System.out.println("Introduce el nombre del archivo en el que deseas descargar el almacen EJ: Almacen.txt ");
					nombreDeArchivo = consola.next();
					tiempoInicio = System.currentTimeMillis();
					A4.descargar(nombreDeArchivo);
					totalTiempo = System.currentTimeMillis() - tiempoInicio;
					System.out.println("El tiempo para el metodo "
					 + totalTiempo + " milisegundos");
					correcto = true;
				}else if (almacen == 39){
					System.out.println("Introduce el nombre del archivo en el que deseas descargar el almacen EJ: Almacen.txt ");
					nombreDeArchivo = consola.next();
					tiempoInicio = System.currentTimeMillis();
					A5.descargar(nombreDeArchivo);
					totalTiempo = System.currentTimeMillis() - tiempoInicio;
					System.out.println("El tiempo para el metodo "
					 + totalTiempo + " milisegundos");
					correcto = true;
				}else if (almacen == 99){
					System.out.println("Introduce el nombre del archivo en el que deseas descargar el almacen EJ: Almacen.txt ");
					nombreDeArchivo = consola.next();
					tiempoInicio = System.currentTimeMillis();
					A6.descargar(nombreDeArchivo);
					totalTiempo = System.currentTimeMillis() - tiempoInicio;
					System.out.println("El tiempo para el metodo "
					 + totalTiempo + " milisegundos");
					correcto = true;
				}else {
					System.out.println("El almacen introducido no es correcto, por favor elige entre (0|1|9|19|39|99)");
				}
				}
				
			}else if (metodo == 11){ //Metodo 10
				System.out.println("Elige el almacen con el que quieres ejecutar el metodo(0|1|9|19|39|99)");
				correcto = false;
				while(!correcto){
				almacen = consola.nextInt();
				if (almacen == 0){
					System.out.println("Introduce el nombre del profesor con el que quieres ejecutar el metodo");
					profesor = consola.next();
					tiempoInicio = System.currentTimeMillis();
					B1 = A1.estudiantesDeProfesor(profesor);
					totalTiempo = System.currentTimeMillis() - tiempoInicio;
					System.out.println("El tiempo para el metodo "
					 + totalTiempo + " milisegundos");
					correcto = true;
				}else if (almacen == 1){
					System.out.println("Introduce el nombre del profesor con el que quieres ejecutar el metodo");
					profesor = consola.next();
					tiempoInicio = System.currentTimeMillis();
					B1 = A2.estudiantesDeProfesor(profesor);
					totalTiempo = System.currentTimeMillis() - tiempoInicio;
					System.out.println("El tiempo para el metodo "
					 + totalTiempo + " milisegundos");
					correcto = true;
				}else if (almacen == 9){
					System.out.println("Introduce el nombre del profesor con el que quieres ejecutar el metodo");
					profesor = consola.next();
					tiempoInicio = System.currentTimeMillis();
					B1 = A3.estudiantesDeProfesor(profesor);
					totalTiempo = System.currentTimeMillis() - tiempoInicio;
					System.out.println("El tiempo para el metodo "
					 + totalTiempo + " milisegundos");
					correcto = true;
				}else if (almacen == 19){
					System.out.println("Introduce el nombre del profesor con el que quieres ejecutar el metodo");
					profesor = consola.next();
					tiempoInicio = System.currentTimeMillis();
					B1 = A4.estudiantesDeProfesor(profesor);
					totalTiempo = System.currentTimeMillis() - tiempoInicio;
					System.out.println("El tiempo para el metodo "
					 + totalTiempo + " milisegundos");
					correcto = true;
				}else if (almacen == 39){
					System.out.println("Introduce el nombre del profesor con el que quieres ejecutar el metodo");
					profesor = consola.next();
					tiempoInicio = System.currentTimeMillis();
					B1 = A5.estudiantesDeProfesor(profesor);
					totalTiempo = System.currentTimeMillis() - tiempoInicio;
					System.out.println("El tiempo para el metodo "
					 + totalTiempo + " milisegundos");
					correcto = true;
				}else if (almacen == 99){
					System.out.println("Introduce el nombre del profesor con el que quieres ejecutar el metodo");
					profesor = consola.next();
					tiempoInicio = System.currentTimeMillis();
					B1 = A6.estudiantesDeProfesor(profesor);
					totalTiempo = System.currentTimeMillis() - tiempoInicio;
					System.out.println("El tiempo para el metodo "
					 + totalTiempo + " milisegundos");
					correcto = true;
				}else {
					System.out.println("El almacen introducido no es correcto, por favor elige entre (0|1|9|19|39|99)");
				}
				}
				B1.clear();
			}else if(metodo == 12){ //Metodo 11
				System.out.println("Elige el almacen con el que quieres ejecutar el metodo(0|1|9|19|39|99)");
				correcto = false;
				while(!correcto){
				almacen = consola.nextInt();
				if (almacen == 0){
					System.out.println("Introduce el nombre de la universidad con la que quieres ejecutar el metodo");
					universidad = consola.next();
					tiempoInicio = System.currentTimeMillis();
					B1 = A1.profesoresDeUniversidad(universidad);
					totalTiempo = System.currentTimeMillis() - tiempoInicio;
					System.out.println("El tiempo para el metodo "
					 + totalTiempo + " milisegundos");
					correcto = true;
				}else if (almacen == 1){
					System.out.println("Introduce el nombre de la universidad con la que quieres ejecutar el metodo");
					universidad = consola.next();
					tiempoInicio = System.currentTimeMillis();
					B1 = A2.profesoresDeUniversidad(universidad);
					totalTiempo = System.currentTimeMillis() - tiempoInicio;
					System.out.println("El tiempo para el metodo "
					 + totalTiempo + " milisegundos");
					correcto = true;
				}else if (almacen == 9){
					System.out.println("Introduce el nombre de la universidad con la que quieres ejecutar el metodo");
					universidad = consola.next();
					tiempoInicio = System.currentTimeMillis();
					B1 = A3.profesoresDeUniversidad(universidad);
					totalTiempo = System.currentTimeMillis() - tiempoInicio;
					System.out.println("El tiempo para el metodo "
					 + totalTiempo + " milisegundos");
					correcto = true;
				}else if (almacen == 19){
					System.out.println("Introduce el nombre de la universidad con la que quieres ejecutar el metodo");
					universidad = consola.next();
					tiempoInicio = System.currentTimeMillis();
					B1 = A4.profesoresDeUniversidad(universidad);
					totalTiempo = System.currentTimeMillis() - tiempoInicio;
					System.out.println("El tiempo para el metodo "
					 + totalTiempo + " milisegundos");
					correcto = true;
				}else if (almacen == 39){
					System.out.println("Introduce el nombre de la universidad con la que quieres ejecutar el metodo");
					universidad = consola.next();
					tiempoInicio = System.currentTimeMillis();
					B1 = A5.profesoresDeUniversidad(universidad);
					totalTiempo = System.currentTimeMillis() - tiempoInicio;
					System.out.println("El tiempo para el metodo "
					 + totalTiempo + " milisegundos");
					correcto = true;
				}else if (almacen == 99){
					System.out.println("Introduce el nombre de la universidad con la que quieres ejecutar el metodo");
					universidad = consola.next();
					tiempoInicio = System.currentTimeMillis();
					B1 = A6.profesoresDeUniversidad(universidad);
					totalTiempo = System.currentTimeMillis() - tiempoInicio;
					System.out.println("El tiempo para el metodo "
					 + totalTiempo + " milisegundos");
					correcto = true;
				}else {
					System.out.println("El almacen introducido no es correcto, por favor elige entre (0|1|9|19|39|99)");
				}
				}
				B1.clear();
			}else if (metodo == 0){
				salir = true;
				System.out.println("/////////////////////////////////////////////////////////");
				System.out.println("/////////////////////////////////////////////////////////");
				System.out.println("/////////////////////////////////////////////////////////");
				System.out.println("Esta aplicacion ha sido creada en el 2012-2013 por: ");
				System.out.println("Adrian Nuñez, Markel Picado y Anartz Recalde");
				System.out.println("Para la asignatura de Estructuras de Datos y Algoritmos");
				System.out.println("/////////////////////////////////////////////////////////");
				System.out.println("/////////////////////////////////////////////////////////");
				System.out.println("/////////////////////////////////////////////////////////");
			}
		}
		
		
	}
}