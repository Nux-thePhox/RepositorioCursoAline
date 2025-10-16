package com.mx.herencia;

public class PrincipalHerencia {
	
	public static void main(String[] args) {
		
		Hijo hijo1 = new Hijo("lalo", "quintana", 12, 1.60, "mexicana", "moreno", "cafe", "delgado");
		System.out.println(hijo1);
		
		hijo1.setApellido("garza");
		System.out.println(hijo1);
		hijo1.trabajar();
	}
}
