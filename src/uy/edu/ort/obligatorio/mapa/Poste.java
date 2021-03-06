package uy.edu.ort.obligatorio.mapa;

public class Poste {
	
	private double coordX;
	
	private double coordY;
	
	private String nombre;
	
	private boolean existe;
	
	public Poste() {}
	
	public Poste(double coordX, double coordY, String nombre) {
		this.coordX = coordX;
		this.coordY = coordY;
		this.nombre = nombre;
		this.existe = true;
	}
	
	// Crea un Poste auxiliar, para comparar las coordenadas.
	public Poste(double coordX2, double coordY2) {
		this.coordX = coordX2;
		this.coordY = coordY2;
		this.existe = true;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Poste) {
			Poste tmpPoste = (Poste) obj;
			if(Double.compare(tmpPoste.coordX, this.coordX) == 0 && 
					Double.compare(tmpPoste.coordY, this.coordY) == 0 && 
					this.existe) {
				return true;
			}
			return false;
		}
		return false;
	}

	public double getCoordX() {
		return coordX;
	}

	public void setCoordX(double coordX) {
		this.coordX = coordX;
	}

	public double getCoordY() {
		return coordY;
	}

	public void setCoordY(double coordY) {
		this.coordY = coordY;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean isExiste() {
		return existe;
	}

	public void setExiste(boolean existe) {
		this.existe = existe;
	}
	
	@Override
    public String toString() {
        return this.getCoordX() + ";" + this.getCoordY() + ";" + this.getNombre() + "|";
    }
	
}
