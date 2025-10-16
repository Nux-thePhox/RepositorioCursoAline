package com.mx.abstracta.practica.entidad;

import com.mx.abstracta.practica.entidadabstracta.Empleado;

public class EmpleadoPorHora extends Empleado{

	public EmpleadoPorHora(String nombre, int edad, double salario) {
		super(nombre, edad, salario);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double calcularBono() {
		// TODO Auto-generated method stub
		int edad = this.getEdad();
		return edad > 25 ? (edad-25) * 100 : 0.0; 
	}
	
}
