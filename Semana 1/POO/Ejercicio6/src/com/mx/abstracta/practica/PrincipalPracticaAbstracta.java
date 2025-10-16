package com.mx.abstracta.practica;

import com.mx.abstracta.practica.entidad.EmpleadoPorHora;
import com.mx.abstracta.practica.entidad.EmpleadoTiempoCompleto;

public class PrincipalPracticaAbstracta {
	public static void main(String[] args) {
		EmpleadoPorHora empleadoPorHora = new EmpleadoPorHora("Toji Zenin", 45, 20000);
		EmpleadoTiempoCompleto empleadoTiempoCompleto = new EmpleadoTiempoCompleto("Satoru Gojo", 18, 10000);
		
		System.out.println("=================================================================");
		System.out.println("Empleado por hora: "+empleadoPorHora
				+"su bono es: "+empleadoPorHora.calcularBono());
		System.out.println("=================================================================");
		System.out.println("Empleado por hora: "+empleadoTiempoCompleto
				+"su bono es: "+empleadoTiempoCompleto.calcularBono());
	}
}
