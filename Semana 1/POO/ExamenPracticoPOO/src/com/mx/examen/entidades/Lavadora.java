package com.mx.examen.entidades;

import static com.mx.examen.constantes.ValoresElectrodomestico.CARGA_POR_DEFECTO;

import com.mx.examen.superclases.Electrodomestico;
//import static com.mx.examen.constantes.ListaConstantes.*;


public class Lavadora extends Electrodomestico{
	private float carga;
	
	public Lavadora() {
		this.carga = CARGA_POR_DEFECTO;
	}

	public Lavadora(float precio, float peso) {
		super(precio, peso);
		this.carga = CARGA_POR_DEFECTO;
	}

	public Lavadora(float precio, String color, char consumoEnergetico, float peso, float carga) {
		super(precio, color, consumoEnergetico, peso);
		this.carga = carga;
	}
	
	public float getCarga() {
		return this.carga;
	}
	
	public float precioFinal() {
		float precioFinal = super.precioFinal();
		if(this.carga > 30.0) {
			precioFinal = precioFinal + 50;
		}
		return precioFinal;
	}

	@Override
	public String toString() {
		return "\n Lavadora [precio=" + precio + ", color=" + color + ", consumoEnergetico=" + consumoEnergetico
				+ ", peso=" + peso + ", carga=" + carga + "]";
	}
	

}
