package com.mx.examen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.mx.examen.entidades.Lavadora;
import com.mx.examen.entidades.Television;
import com.mx.examen.superclases.Electrodomestico;

public class PrincipalExamen {
	
	private static int TIPO_LAVADORA = 1;
	private static int TIPO_TELEVISION = 2;
	
	public static void main(String[] args) {
		
		Electrodomestico[] electrodomesticoArray = obtenArrayElectrodomestico();
		System.out.println("Recibi el siguiente array");
		for (Electrodomestico electrodomestico : electrodomesticoArray) {
			System.out.println(electrodomestico);
		}
		System.out.println("\n--------------------------------------------------------------------"
        		+"--------------------------------------------------------------------");
		HashMap<Integer, List<Electrodomestico>> listasPorTipo; 
		List<String> preciosDeLavadoras = new ArrayList<String>();
		List<String> preciosDeTelevisiones = new ArrayList<String>();
		float precioTotalElectrodomesticos, precioTotalLavadoras, precioTotalTelevision;
		precioTotalTelevision = 0;
		precioTotalElectrodomesticos = 0;
		precioTotalLavadoras = 0;
		
		listasPorTipo = clasificaElectrodomesticos(electrodomesticoArray);
		precioTotalLavadoras = obtenPreciosElectrodomesticos(listasPorTipo.get(TIPO_LAVADORA), preciosDeLavadoras);
		precioTotalTelevision = obtenPreciosElectrodomesticos(listasPorTipo.get(TIPO_TELEVISION), preciosDeTelevisiones);
		precioTotalElectrodomesticos = precioTotalLavadoras + precioTotalTelevision;
		imprimirTabla(listasPorTipo.get(TIPO_LAVADORA), preciosDeLavadoras, listasPorTipo.get(TIPO_TELEVISION), preciosDeTelevisiones);
        System.out.println("\n--------------------------------------------------------------------"
        		+"--------------------------------------------------------------------");
		System.out.println("PRECIO TOTAL DE TELEVISIONES: "+precioTotalTelevision+"\n"
				+"PRECIO TOTAL DE LAVADORAS: "+precioTotalLavadoras+"\n"
				+"PRECIO TOTAL DE ELECTRODOMESTICOS: "+precioTotalElectrodomesticos+"\n");
	}
	

	private static Electrodomestico[] obtenArrayElectrodomestico() {
		Lavadora lavadora = new Lavadora();
		Lavadora lavadora2 = new Lavadora(250, 10);
		Lavadora lavadora3 = new Lavadora(300, 15);
		Lavadora lavadora4 = new Lavadora(450, "Azul", 'A', 20, 25);
		Lavadora lavadora5 = new Lavadora(500, "Rojo", 'B', 25, 45);
		
		Television television = new Television();
		Television television2 = new Television(150, 10);
		Television television3 = new Television(250, 15);
		Television television4 = new Television(250, "Azul", 'A', 20, 40, false);
		Television television5 = new Television(300, "Rojo", 'B', 25, 60, true);
		
		Electrodomestico[] electrodomesticoArray =  {
				lavadora,
				lavadora2,
				lavadora3,
				lavadora4,
				lavadora5,
				television5,
				television4,
				television3,
				television2,
				television
		};
		return electrodomesticoArray;
	}
	
	private static void imprimirTabla(List<Electrodomestico> listaLavadoras, List<String> mensajesLavadoras, 
			List<Electrodomestico> listaTelevisiones, List<String> mensajesTelevisiones) {
        System.out.printf("%-70s | %-70s %n", "PRECIOS DE LAVADORAS", "PRECIOS DE TELEVISIONES");
        System.out.println("--------------------------------------------------------------------"
        +"--------------------------------------------------------------------");
        int indiceLavadoras = 0;
        int indiceTelevisiones = 0;
        String mensajeLavadora, mensajeTelevision;
        do {
        	mensajeLavadora = "";
        	mensajeTelevision = "";
        	if(indiceLavadoras < listaLavadoras.size()) {
        		mensajeLavadora = mensajesLavadoras.get(indiceLavadoras);
        		indiceLavadoras++;
        	}
        	if(indiceTelevisiones < listaTelevisiones.size()) {
        		mensajeTelevision = mensajesTelevisiones.get(indiceTelevisiones);
        		indiceTelevisiones++;
        	}
        	System.out.printf("%-70s | %-70s %n", mensajeLavadora, mensajeTelevision);
        }while(indiceLavadoras < listaLavadoras.size() || indiceTelevisiones < listaTelevisiones.size());
	}
	
	/*
	 * Devuelve la suma de los precios finales de una lista de electrodomesticos, ademas va agregando en una lista de mensajes 
	 * cada precio final obtenido (para propocitos de comparacion también incluyo en los mensajes el precio original) que posteriormente
	 * sera mostrado en pantalla 
	 * */
	private static float obtenPreciosElectrodomesticos(List<Electrodomestico> listaElectrodomestico, List<String> listaMensajes) {
		float sumaPrecio = 0.0f;
		String precioOriginal, precioFinal;
		for(Electrodomestico electrodomestico: listaElectrodomestico) {
			precioOriginal = "Precio Original: "+String.format("%.2f", electrodomestico.getPrecio());
			precioFinal = "Precio Final: "+String.format("%.2f", electrodomestico.precioFinal());
			listaMensajes.add(precioOriginal+" "+precioFinal);
			sumaPrecio += electrodomestico.precioFinal();
		}
		return sumaPrecio;
	}
	
	//Clasifica el arreglo de electrodomesticos en dos listas de electrodomesticos, una de lavadoras y otra de television. 
	private static HashMap<Integer, List<Electrodomestico>> clasificaElectrodomesticos(Electrodomestico[] electrodomesticoArray) {
		HashMap<Integer, List<Electrodomestico>> listasPorTipo = new HashMap<>();
		List<Electrodomestico> listaLavadoras = new ArrayList<>();
		List<Electrodomestico> listaTelevisiones = new ArrayList<>();
		for(Electrodomestico electrodomestico: electrodomesticoArray) {
			if(electrodomestico instanceof Lavadora) {
				listaLavadoras.add(electrodomestico);
			}else if(electrodomestico instanceof Television) {
				listaTelevisiones.add(electrodomestico);
			}
		}
		listasPorTipo.put(TIPO_LAVADORA, listaLavadoras);
		listasPorTipo.put(TIPO_TELEVISION, listaTelevisiones);
		return listasPorTipo;
	}
	
}
