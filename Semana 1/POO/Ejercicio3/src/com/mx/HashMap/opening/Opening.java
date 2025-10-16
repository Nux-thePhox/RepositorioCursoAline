package com.mx.HashMap.opening;

public class Opening {
	
	private String nombre; //clave
	private String anime;
	private String autor;
	private int numeroOpening;
	private int minutosDuracion;
	private int segundosDuracion;

	public Opening() {
	}
	
	public Opening(String nombre) {
		this.nombre = nombre;
	}

	public Opening(String nombre, String anime, String autor, int numeroOpening, int minutosDuracion,
			int segundosDuracion) {
		this.nombre = nombre;
		this.anime = anime;
		this.autor = autor;
		this.numeroOpening = numeroOpening;
		this.minutosDuracion = minutosDuracion;
		this.segundosDuracion = segundosDuracion;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAnime() {
		return anime;
	}

	public void setAnime(String anime) {
		this.anime = anime;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getNumeroOpening() {
		return numeroOpening;
	}

	public void setNumeroOpening(int numeroOpening) {
		this.numeroOpening = numeroOpening;
	}

	public int getMinutosDuracion() {
		return minutosDuracion;
	}

	public void setMinutosDuracion(int minutosDuracion) {
		this.minutosDuracion = minutosDuracion;
	}

	public int getSegundosDuracion() {
		return segundosDuracion;
	}

	public void setSegundosDuracion(int segundosDuracion) {
		this.segundosDuracion = segundosDuracion;
	}

	@Override
	public String toString() {
		return "Opening [nombre=" + nombre + ", anime=" + anime + ", autor=" + autor + ", numeroOpening=" 
				+ numeroOpening+ ", duracion= " + minutosDuracion+"min " + segundosDuracion + "seg]\n";
	}
	
}
