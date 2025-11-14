package com.mx.mascotasyduenios.dominio;

import jakarta.persistence.*;

@Entity
@Table(name = "MASCOTAS")
public class Mascota {

    @Id
    private int idMascota;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_DUENIO")
    private Duenio idDuenio;
    private int edad;
    private String nombre;
    private String especie;
    private String raza;

    public Mascota() {
    }

    public Mascota(int idMascota, Duenio idDuenio, int edad, String nombre, String especie, String raza) {
        this.idMascota = idMascota;
        this.idDuenio = idDuenio;
        this.edad = edad;
        this.nombre = nombre;
        this.especie = especie;
        this.raza = raza;
    }

    public int getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(int idMascota) {
        this.idMascota = idMascota;
    }

    public Duenio getIdDuenio() {
        return idDuenio;
    }

    public void setIdDuenio(Duenio idDuenio) {
        this.idDuenio = idDuenio;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    @Override
    public String toString() {
        return "\nMascota{" +
                "idMascota=" + idMascota +
                ", idDuenio=" + idDuenio +
                ", edad=" + edad +
                ", nombre='" + nombre + '\'' +
                ", especie='" + especie + '\'' +
                ", raza='" + raza + '\'' +
                '}';
    }
}
