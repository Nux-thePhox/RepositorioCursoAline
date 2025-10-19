package com.mx.examen.entidades;

import static com.mx.examen.constantes.ValoresElectrodomestico.RESOLUCION_POR_DEFECTO;
import static com.mx.examen.constantes.ValoresElectrodomestico.SIN_SINTONIZADOR;
import static com.mx.examen.constantes.ValoresElectrodomestico.CON_SINTONIZADOR;


import com.mx.examen.superclases.Electrodomestico;


public class Television extends Electrodomestico{
	
	private float resolucion;
	private boolean sintonizadorTDT;
	
	public Television() {
		this.resolucion = RESOLUCION_POR_DEFECTO;
		this.sintonizadorTDT = SIN_SINTONIZADOR;
	}

	public Television(float precio, float peso) {
		super(precio, peso);
		this.resolucion = RESOLUCION_POR_DEFECTO;
		this.sintonizadorTDT = SIN_SINTONIZADOR;
	}

	public Television(float precio, String color, char consumoEnergetico, float peso, float resolucion,
			boolean sintonizadorTDT) {
		super(precio, color, consumoEnergetico, peso);
		this.resolucion = resolucion;
		this.sintonizadorTDT = sintonizadorTDT;
	}

	public float getResolucion() {
		return resolucion;
	}

	public boolean isSintonizadorTDT() {
		return sintonizadorTDT;
	}
	
	
	public float precioFinal() {
		float precioFinal = super.precioFinal();
		if(resolucion > 40) {
			precioFinal = precioFinal + (precioFinal*0.4f); 
			if(this.sintonizadorTDT == CON_SINTONIZADOR) {
				precioFinal = precioFinal + 50;
			}
		}
		return precioFinal;
	}

	@Override
	public String toString() {
		return "\n Television [precio=" + precio + ", color=" + color + ", consumoEnergetico=" + consumoEnergetico
				+ ", peso=" + peso + ", resolucion=" + resolucion + ", sintonizadorTDT=" + sintonizadorTDT + "]";
	}
	
	
}
