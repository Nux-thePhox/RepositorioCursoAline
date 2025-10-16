package com.mx.abstracta;

public class Abogado extends Profesionista{
	
	private String tipo;
	private int honorario;

	@Override
	public void trabajar() {
		// TODO Auto-generated method stub
		System.out.println("Muy bonito discurso señor, pero yo me pregunto, que es un contrato?\n"
				+ "El diccionario lo define como un acuerdo legal que no se puede romper… "
				+ "¡QUE NO SE PUEDE ROMPER!");
	}

	public Abogado(String nombre, String apellido, int edad, int cedula, String universidad, String tipo,
			int honorario) {
		super(nombre, apellido, edad, cedula, universidad);
		this.tipo = tipo;
		this.honorario = honorario;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getHonorario() {
		return honorario;
	}

	public void setHonorario(int honorario) {
		this.honorario = honorario;
	}

	@Override
	public String toString() {
		return "Abogado [nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + ", cedula=" + cedula
				+ ", universidad=" + universidad + ", tipo=" + tipo + ", honorario=" + honorario + "]";
	}

	
	
}
