package com.mx.herencia.practica;

public class Cuenta {
	private String titular;
	private double cantidad;
	
	public Cuenta() {
		// TODO Auto-generated constructor stub
	}

	public Cuenta(String titular, double cantidad) {
		this.titular = titular;
		this.cantidad = cantidad;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public double getCantidad() {
		return cantidad;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}
	
	public void mostrarInfo() {
		System.out.println(this.toString());
	}

	@Override
	public String toString() {
		return "Cuenta [titular=" + titular + ", cantidad=" + cantidad + "]";
	}
	
	
}
