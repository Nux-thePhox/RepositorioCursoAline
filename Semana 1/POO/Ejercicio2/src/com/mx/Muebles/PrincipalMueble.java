package com.mx.Muebles;

public class PrincipalMueble {
	
	public static void main(String[] args) {
		
		Mueble mueble = new Mueble("gris", 8000.78, 5, "tela", "sala");
		Mueble m2 = new Mueble("Terracota", 2000, 2, "caoba", "sala");
		Mueble sofa = new Mueble("azul", 12000.50, 8, "cuero", "sala");
		Mueble m3 = new Mueble("cafe", 6999.99, 2, "madera", "comedor");
		Mueble miMueble = new Mueble("Verde", 5000.00, 1, "tela", "sala");
	
		MueblesImpl mueblesImp = new MueblesImpl();
		
		//create
		mueblesImp.create(mueble);
		mueblesImp.create(m2);
		mueblesImp.create(sofa);
		mueblesImp.create(m3);
		mueblesImp.create(miMueble);
		
		//read
		mueblesImp.read();
		
		//update
		Mueble aux;
		aux = mueblesImp.buscar(2);
		aux.setMaterial("vinipiel");
		System.out.println(mueblesImp.buscar(2));
		
		//eliminar
		mueblesImp.delete(2);
		mueblesImp.read();
		
		//contar
		mueblesImp.contarElementos();
	}
}
