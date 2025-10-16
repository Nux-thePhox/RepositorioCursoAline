package com.mx.HashMap;

public interface IMetodosCrudMueble {
	public void guardar(Mueble mueble);
	public void mostrar();
	public void editar(Mueble mueble);
	public void eliminar(Mueble mueble);
	
	public Mueble buscar(Mueble mueble);
}
