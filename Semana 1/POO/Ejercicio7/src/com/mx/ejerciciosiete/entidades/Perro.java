package com.mx.ejerciciosiete.entidades;

public class Perro extends Animal{
	
	
	public Perro(String nombre, String color, String tamanio, String tipoReproduccion) {
		super(nombre, color, tamanio, tipoReproduccion);
	}
	
	@Override
	public void hacerSonido() {
		System.out.println(nombre +" hace guau guau");
	}

}
