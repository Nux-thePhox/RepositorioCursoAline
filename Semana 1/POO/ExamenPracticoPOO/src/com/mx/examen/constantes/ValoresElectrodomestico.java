package com.mx.examen.constantes;

import java.util.List;

public class ValoresElectrodomestico {
	
	public static final List<String> listaColoresDisponibles = List.of(
			"Blanco", "Negro", "Rojo", "Azul");
	public static final List<String> listaConsumo = List.of("A", "B", "C", "D", "E", "F");
	
	//Valores por defecto
	public static final String COLOR_POR_DEFECTO = listaColoresDisponibles.get(0);
	public static final char CONSUMO_POR_DEFECTO = listaConsumo.get(listaConsumo.size()-1).charAt(0);
	public static final float PRECIO_POR_DEFECTO = 100.00f;
	public static final float PESO_POR_DEFECTO = 5.0F;
	
	public static final String UNIDAD_PRECIO = "€";
	public static final String UNIDAD_PESO = "kg";
	
	
	
}
