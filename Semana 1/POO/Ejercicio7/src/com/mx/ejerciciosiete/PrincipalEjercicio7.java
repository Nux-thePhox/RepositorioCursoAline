package com.mx.ejerciciosiete;

import com.mx.ejerciciosiete.entidades.Gato;
import com.mx.ejerciciosiete.entidades.Perro;

public class PrincipalEjercicio7 {
	
	public static void main(String[] args) {
		Perro perro = new Perro("loba", "humilde", "mediana", "vivipara");
		Gato gato = new Gato("Gwen", "B&W", "Estandar", "vivipara");
		
		perro.hacerSonido();
		gato.hacerSonido();
	}
}
