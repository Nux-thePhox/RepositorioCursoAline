package com.mx.ejerciciosiete.practica.entidades;

import java.util.Random;
import static com.mx.ejerciciosiete.practica.constantes.Constantes.LONGITUD_DNI;

import com.mx.ejerciciosiete.practica.constantes.Constantes;
public class Persona {
	
	private String nombre;
	private short edad;
	private String dni;
	private char sexo='H';
	private float peso;
	private float altura;
	
	public Persona() {
		// TODO Auto-generated constructor stub
		this.dni = generaDNI();
	}

	public Persona(String nombre, short edad, char sexo) {
		this.nombre = nombre;
		this.edad = edad;
		comprobarSexo(sexo);
		this.dni = generaDNI();
	}

	public Persona(String nombre, short edad, String dni, char sexo, float peso, float altura) {
		this.nombre = nombre;
		this.edad = edad;
		this.dni = dni;
		comprobarSexo(sexo);
		this.peso = peso;
		this.altura = altura;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setEdad(short edad) {
		this.edad = edad;
	}

	public void setSexo(char sexo) {
		comprobarSexo(sexo);
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public void setAltura(float altura) {
		this.altura = altura;
	}
	
	public int calcularIMC() {
		float imc = this.peso/(this.altura*this.altura);
		if(imc < 20) {
			return -1;
		} else if(imc >= 20 && imc <= 25) {
			return 0;
		}
		return 1;
	}
	
	public boolean esMayorDeEdad() {
		return this.edad > 18;
	}
	
	private void comprobarSexo(char sexo) {
		if(sexo == 'H' || sexo == 'M') {
			this.sexo = sexo;
		}
		else {
			this.sexo = 'H';
		}
	}
	
	private String generaDNI() {
		Random random = new Random();
		String dni = "";
		int digito;
		short i;
		for(i=0; i<LONGITUD_DNI; i++) {
			digito = random.nextInt(10);
			dni = dni+letraCorrespondiente(digito);
		}
		return dni;
	}
	
	private char letraCorrespondiente(int digito) {
		char[] letraCorrespondiente = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
		return letraCorrespondiente(digito);
	}

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", edad=" + edad + ", dni=" + dni + ", sexo=" + sexo 
				+ ", peso=" + peso
				+ ", altura=" + altura + "]";
	}
	
	
}
