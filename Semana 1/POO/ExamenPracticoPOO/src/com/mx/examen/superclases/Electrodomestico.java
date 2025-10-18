package com.mx.examen.superclases;

import static com.mx.examen.constantes.ValoresElectrodomestico.*;

public class Electrodomestico {
	
	protected float precio;
	protected String color;
	protected char consumoEnergetico;
	protected float peso;
	
	public Electrodomestico() {
		this.color = COLOR_POR_DEFECTO;
		this.consumoEnergetico = CONSUMO_POR_DEFECTO;
		this.precio = PRECIO_POR_DEFECTO;
		this.peso = PESO_POR_DEFECTO;
	}

	public Electrodomestico(float precio, float peso) {
		this.precio = precio;
		this.peso = peso;
		this.color = COLOR_POR_DEFECTO;
		this.consumoEnergetico = CONSUMO_POR_DEFECTO;
	}

	public Electrodomestico(float precio, String color, char consumoEnergetico, float peso) {
		this.precio = precio;
		this.color = color;
		this.consumoEnergetico = consumoEnergetico;
		this.peso = peso;
	}
	
	@Override
	public String toString() {
		return "Electrodomestico [precio=" + precio + ", color=" + color + ", consumoEnergetico=" + consumoEnergetico
				+ ", peso=" + peso + "]";
	}
	
	
}
