package com.mx.examen.superclases;

import static com.mx.examen.constantes.ValoresElectrodomestico.*;
import static com.mx.examen.constantes.ListaConstantes.*;

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
		this.color = comprobarColor(color);
		this.consumoEnergetico = comprobarConsumoEnergetico(consumoEnergetico);
		this.peso = peso < 0 ? PESO_POR_DEFECTO : peso; //agrego validacion para no aceptar pesos negativos
	}
	
	@Override
	public String toString() {
		return "Electrodomestico [precio=" + precio + ", color=" + color + ", consumoEnergetico=" + consumoEnergetico
				+ ", peso=" + peso + "]";
	}

	//Metodos solicitados
	
	//Metodos get de todos los atributos
	
	public float getPrecio() {
		return precio;
	}

	public String getColor() {
		return color;
	}

	public char getConsumoEnergetico() {
		return consumoEnergetico;
	}

	public float getPeso() {
		return peso;
	}
	
	
	/*Comprueba que la letra es correcta, si no es correcta usara la letra por defecto.
	 * Se invocara al crear el objeto y no sera visible*/
	private char comprobarConsumoEnergetico(char letra) {
		int indice = listaConsumo.indexOf(letra);
		return indice != INDICE_INEXISTENTE_EN_LISTA ? listaConsumo.get(indice) : CONSUMO_POR_DEFECTO;
	}
	
	/*comprueba que el color es correcto, sino lo es usa el color por defecto. Se invocara al crear el 
	 * objeto y no sera visible.*/
	private String comprobarColor(String color) {
		int indice = listaColoresDisponibles.indexOf(color);
		return indice != INDICE_INEXISTENTE_EN_LISTA ? 
				listaColoresDisponibles.get(indice): COLOR_POR_DEFECTO;
	}
	
	/*según el consumo energético, aumentara su precio, y según su tamaño, también. 
	 * Esta es la lista de precios: incrementoPorConsumo*/
	public float precioFinal() {
		return incrementoPorConsumo.get(this.consumoEnergetico) + this.precio + this.incrementoPorTamanio();
	}
	
	private float incrementoPorTamanio() {
		if((this.peso >= 0.0) && (this.peso <= 19.0)) {
			return 10;
		}
		if((this.peso >= 20.0) && (this.peso <= 49.0)) {
			return 50;
		}
		if((this.peso >= 50.0) && (this.peso <= 79.0)) {
			return 80;
		}
		return 100;
	}
	
}
