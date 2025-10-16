package com.mx.abstracta.practicados.entidades;

import com.mx.abstracta.practicados.entidadabs.Vehiculo;

/**
 * 
 */
public class Auto extends Vehiculo{
	
	private String tipoCombustible;
	
	public Auto(String marca, String modelo, int anio, double velocidadActual, String tipoCombustible) {
		super(marca, modelo, anio, velocidadActual);
		this.tipoCombustible = tipoCombustible;
	}

	public String getTipoCombustible() {
		return tipoCombustible;
	}

	public void setTipoCombustible(String tipoCombustible) {
		this.tipoCombustible = tipoCombustible;
	}

	@Override
	public String calcularConsumo(double km) {
		// TODO Auto-generated method stub
		final String GASOLINA = "gasolina";
		final String HIBRIDO = "hibrido";
		final String ELECTRICO = "electrico";
		
		double consumo = 0.0;
		
		switch(this.tipoCombustible) {
		case GASOLINA:
			consumo = km / 12;
			return("Se consumieron "+consumo+" litros en estos "+km+"km");
		case HIBRIDO:
			consumo = km / 20;
			return("Se consumieron "+consumo+" litros en estos "+km+"km");
		case ELECTRICO:
			consumo = km / 50;
			return("Se consumieron "+consumo+" unidades de energía en estos "+km+"km");
		}
		return "No hay consumo para este tipo de combustible";
	}

	@Override
	public String toString() {
		return "Auto [tipoCombustible=" + tipoCombustible + "]";
	}
	
}
