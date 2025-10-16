package com.mx.abstracta.practica.entidad;

import com.mx.abstracta.practica.entidadabstracta.Empleado;

public class EmpleadoTiempoCompleto extends Empleado{

	public EmpleadoTiempoCompleto(String nombre, int edad, double salario) {
		super(nombre, edad, salario);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double calcularBono() {
		// TODO Auto-generated method stub
		return this.getSalario() * 0.2;
	}

}
