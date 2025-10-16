package com.mx.abstracta;

public class PrincipalAbstracta {
	public static void main(String[] args) {
		Abogado abogado = new Abogado("Cristian", "Rodriguez", 32, 47855, "buap", "penal", 5000);
		System.out.println(abogado);
		abogado.trabajar();
		abogado.cobrar(abogado.getTipo(),abogado.getHonorario());
	}
}
