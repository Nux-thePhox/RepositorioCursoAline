package com.mx.ejerciciosiete.entidades;

public class Gato extends Animal{
	
	
	
	public Gato(String nombre, String color, String tamanio, String tipoReproduccion) {
		super(nombre, color, tamanio, tipoReproduccion);
	}

	@Override
	public void hacerSonido() {
		System.out.println(nombre+" hace miau");
	}
	
	
}
