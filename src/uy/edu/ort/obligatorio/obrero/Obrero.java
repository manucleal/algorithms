package uy.edu.ort.obligatorio.obrero;

public class Obrero {
	
	private String cedula;
	
	private String nombre;
	
	public Obrero(String cedula, String nombre) {
		this.cedula = cedula;
		this.nombre = nombre;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	

}
