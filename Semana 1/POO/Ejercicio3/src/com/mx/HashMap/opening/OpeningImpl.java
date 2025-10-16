package com.mx.HashMap.opening;

import java.util.HashMap;

public class OpeningImpl implements IMetodosCrudOpening{

	private HashMap<String, Opening> hash = new HashMap<String, Opening>();

	@Override
	public void guardar(Opening opening) {
		// TODO Auto-generated method stub
		hash.put(opening.getNombre(), opening);
	}

	@Override
	public void mostrar() {
		// TODO Auto-generated method stub
		System.out.println(hash);
	}

	@Override
	public void editar(Opening opening) {
		// TODO Auto-generated method stub
		hash.replace(opening.getNombre(), opening);
	}

	@Override
	public void eliminar(Opening opening) {
		// TODO Auto-generated method stub
		hash.remove(opening.getNombre());
	}

	@Override
	public Opening buscar(Opening opening) {
		// TODO Auto-generated method stub
		return hash.get(opening.getNombre());
	}


}
