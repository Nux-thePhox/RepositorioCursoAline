package com.mx.examen.constantes;

import java.util.List;
import java.util.Map;

public class ValoresElectrodomestico {
	
	public static final List<String> listaColoresDisponibles = List.of(
			"Blanco", "Negro", "Rojo", "Azul");
	public static final List<Character> listaConsumo = List.of('A', 'B', 'C', 'D', 'E', 'F');
	
	//Valores por defecto
	public static final String COLOR_POR_DEFECTO = listaColoresDisponibles.get(0);
	public static final char CONSUMO_POR_DEFECTO = listaConsumo.get(listaConsumo.size()-1);
	public static final float PRECIO_POR_DEFECTO = 100.00f;
	public static final float PESO_POR_DEFECTO = 5.0f;
	public static final float CARGA_POR_DEFECTO = 5.0f;
	public static final float RESOLUCION_POR_DEFECTO = 20;
	public static final boolean CON_SINTONIZADOR = true;
	public static final boolean SIN_SINTONIZADOR = false;

	
	//Unidades de medida
	public static final String UNIDAD_PRECIO = "€";
	public static final String UNIDAD_PESO = "kg";
	public static final String UNIDAD_RESOLUCION = "pulgadas";
	
	public static final Map<Character, Float> incrementoPorConsumo = Map.of(
			listaConsumo.get(0), 100f,
			listaConsumo.get(1), 80f,
			listaConsumo.get(2), 60f,
			listaConsumo.get(3), 50f,
			listaConsumo.get(4), 30f,
			listaConsumo.get(5), 10f
			);
	
	
}
