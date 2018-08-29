package application;


public class estado {
	boolean aceptacion;
	String nombre;
	String []letras;
	public estado(boolean aceptacion, String nombre, String[] letras) {
		super();
		this.aceptacion = aceptacion;
		this.nombre = nombre;
		this.letras = letras;
	}
	public boolean isAceptacion() {
		return aceptacion;
	}
	public void setAceptacion(boolean aceptacion) {
		this.aceptacion = aceptacion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String[] getLetras() {
		return letras;
	}
	public void setLetras(String[] letras) {
		this.letras = letras;
	}
	

}
