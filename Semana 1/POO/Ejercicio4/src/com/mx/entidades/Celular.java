package com.mx.entidades;

public class Celular {
	
	private long imei; //Clave
	private String marca;
	private String modelo;
	private String color;
	private double precio;
	private int ram;
	private String procesador;

	public Celular() {
		
	}

	public Celular(long imei, String marca, String modelo, String color, double precio, 
			int ram, String procesador) {
		this.imei = imei;
		this.marca = marca;
		this.modelo = modelo;
		this.color = color;
		this.precio = precio;
		this.ram = ram;
		this.procesador = procesador;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getRam() {
		return ram;
	}

	public void setRam(int ram) {
		this.ram = ram;
	}

	public String getProcesador() {
		return procesador;
	}

	public void setProcesador(String procesador) {
		this.procesador = procesador;
	}

	public long getImei() {
		return imei;
	}

	@Override
	public String toString() {
		return "\n Celular [imei=" + imei + ", marca=" + marca + ", modelo=" + modelo + ", color=" + color + ", precio="
				+ precio + ", ram=" + ram + ", procesador=" + procesador + ", getMarca()=" + getMarca()
				+ ", getModelo()=" + getModelo() + ", getColor()=" + getColor() + ", getPrecio()=" + getPrecio()
				+ ", getRam()=" + getRam() + ", getProcesador()=" + getProcesador() + ", getImei()=" + getImei()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
	
}
