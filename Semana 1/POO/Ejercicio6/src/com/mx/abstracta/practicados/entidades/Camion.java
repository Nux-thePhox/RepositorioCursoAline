package com.mx.abstracta.practicados.entidades;

import com.mx.abstracta.practicados.entidadabs.Vehiculo;

public class Camion extends Vehiculo{
	
	private int capacidadCarga; //toneladas

	public Camion(String marca, String modelo, int anio, double velocidadActual, int capacidadCarga) {
		super(marca, modelo, anio, velocidadActual);
		this.capacidadCarga = capacidadCarga;
	}

	public int getCapacidadCarga() {
		return capacidadCarga;
	}

	public void setCapacidadCarga(int capacidadCarga) {
		this.capacidadCarga = capacidadCarga;
	}

	@Override
	public String calcularConsumo(double km) {
		// TODO Auto-generated method stub
		double consumo;
		if(capacidadCarga > 10) {
			consumo = km/5;
		}
		consumo = km/8;
		return "Se consumieron "+consumo+" litros en estos "+km+"km";

	}

	@Override
	public String toString() {
		return "Camion [capacidadCarga=" + capacidadCarga + "]";
	}
	
}
