package com.mx.traductor;

import java.util.HashMap;

public class TraductorPalabrasImpl implements TraductorPalabraMetodos{
	
	private HashMap<String, String> diccionario = new HashMap<String, String>();

	@Override
	public void agregar(String nuevaPalabra, String palabraTraducida) {
		// TODO Auto-generated method stub
		diccionario.put(nuevaPalabra, palabraTraducida);
	}

	@Override
	public String buscarPorPalabraClave(String palabraClave) {
		// TODO Auto-generated method stub
		return diccionario.get(palabraClave);
	}

	@Override
	public void muestraTodosLosRegistros() {
		// TODO Auto-generated method stub
		System.out.println("Los registros en el diccionario son: \n "+diccionario);
	}

}
