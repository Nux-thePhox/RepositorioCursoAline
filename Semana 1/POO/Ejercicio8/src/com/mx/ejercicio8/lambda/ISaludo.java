package com.mx.ejercicio8.lambda;

/*
 * La anotacion FunctionalInterface es para indicar una interfaz funcional que solo puede contener un
 * unico metodo abstracto, ni más ni menos.
 * */

@FunctionalInterface
public interface ISaludo {
	public String saludar(String saludo, String despedida);
}
