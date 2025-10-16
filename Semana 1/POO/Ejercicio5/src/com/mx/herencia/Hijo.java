package com.mx.herencia;

public class Hijo extends Padre{
	
	private String colorOjos;
	private String complexion;
	
	public Hijo() {
		
	}

	public Hijo(String nombre, String apellido, int edad, double estatura, String nacionalidad, String tez,
			String colorOjos, String complexion) {
		super(nombre, apellido, edad, estatura, nacionalidad, tez);
		this.colorOjos = colorOjos;
		this.complexion = complexion;
	}

	public String getColorOjos() {
		return colorOjos;
	}

	public void setColorOjos(String colorOjos) {
		this.colorOjos = colorOjos;
	}

	public String getComplexion() {
		return complexion;
	}

	public void setComplexion(String complexion) {
		this.complexion = complexion;
	}

	@Override
	public String toString() {
		return "Hijo [nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + ", estatura=" + estatura
				+ ", nacionalidad=" + nacionalidad + ", tez=" + tez + ", colorOjos=" + colorOjos + ", complexion="
				+ complexion + "]";
	}
	
}
