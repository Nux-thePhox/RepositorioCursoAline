package com.mx.herencia.practica;

public class CuentaAhorro extends Cuenta{
	
	private double tasaInteres;
	
	public CuentaAhorro() {
		// TODO Auto-generated constructor stub
	}
	
	public double getTasaInteres() {
		return tasaInteres;
	}

	public void setTasaInteres(double tasaInteres) {
		this.tasaInteres = tasaInteres;
	}

	public double calcularInteres() {
		double interes = getCantidad()*tasaInteres/100;
		return interes;
	}
}
