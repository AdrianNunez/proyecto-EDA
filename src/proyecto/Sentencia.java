package proyecto;

public class Sentencia implements Comparable<Sentencia> {
	
	private String sujeto;
	private String propiedad;
	private String objeto;
	
	public Sentencia(){	
	}

	public Sentencia(String s,String p,String o){
		sujeto=s;
		propiedad=p;
		objeto=o;
	}
	
	public String verSujeto(){
		return sujeto;
	}
	
	public String verPropiedad(){
		return propiedad;
	}
	
	public String verObjeto(){
		return objeto;
	}
	
	public boolean equals(Sentencia s){
		return (this.sujeto.equals(s.sujeto) && this.propiedad.equals(s.propiedad) && this.objeto.equals(s.objeto));
	}
	
	public int compareTo(Sentencia s){
		if (this.equals(s)) return 0;
		else if(this.sujeto.compareTo(s.sujeto)>0) return 1;
		else if(this.sujeto.compareTo(s.sujeto)<0) return -1;
		else{
			if(this.propiedad.compareTo(s.propiedad)>0) return 1;
			else if(this.propiedad.compareTo(s.propiedad)<0) return -1;
			else{
				if(this.objeto.compareTo(s.objeto)>0) return 1;
				else return -1;
			}
		}
	}
	
	public String toString()
	{
		return sujeto + " " + propiedad + " " + objeto + " .";
	}
	
}
