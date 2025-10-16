package com.mx.principal;

public interface MetodosList {
	public void guardar(Object object);
	public void editar(int indiceLista, Object object);
	public void eliminar(int indiceLista);
	public Object buscar(int indiceLista);
	public void mostrar();
}
