package com.mx.opening;

public interface IMetodosCrudOpening {
	public void create(Opening opening);
	public void read();
	public void update(int indice, Opening opening);
	public void delete(int indice);
	
	public Opening buscar(int indice);
}
