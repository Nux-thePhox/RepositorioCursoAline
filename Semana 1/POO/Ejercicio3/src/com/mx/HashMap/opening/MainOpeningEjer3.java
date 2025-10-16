package com.mx.HashMap.opening;

public class MainOpeningEjer3 {
	public static void main(String[] args) {
		Opening openingBoticaria = new Opening("Ambivalent", "Los diarios de la Boticaria", "Uru", 2, 4, 2);
		Opening openingKimetsu = new Opening("Zankyosanka", "Kimetsu no Yaiba", "Aimer", 3, 3, 2);
		Opening openingDanDaDan = new Opening("On The Way", "DanDaDan", "AiNA THE END", 2, 3, 38);
		Opening openingShumatsuValkyre = new Opening("RUDE LOSE DANCE", "Shumatsu No Valkyre", "Minami", 2, 
				4, 45);
		
		Opening auxOpening = null;
		OpeningImpl openingImpl = new OpeningImpl();
		
		openingImpl.guardar(openingBoticaria);
		openingImpl.guardar(openingKimetsu);
		openingImpl.guardar(openingDanDaDan);
		openingImpl.guardar(openingShumatsuValkyre);
		
		//mostrar
		openingImpl.mostrar();
		
		//buscar
		auxOpening = new Opening("Zankyosanka");
		auxOpening = openingImpl.buscar(auxOpening);
		System.out.println(auxOpening);
		
		//Editar 
		auxOpening = new Opening("Ambivalent");
		auxOpening = openingImpl.buscar(auxOpening);
		auxOpening.setAnime("Kusuriya no Hitorigoto");
		System.out.println(auxOpening);
		
		//Eliminar
		auxOpening = new Opening("On The Way");
		auxOpening = openingImpl.buscar(auxOpening);
		openingImpl.eliminar(auxOpening);
		openingImpl.mostrar();
	}
}
