package com.mx.mascotasyduenios.dominio;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "DUENIOS")
public class Duenio {

    @Id
    private int idDuenio;
    private String nombre;
    private String ciudad;
    private String edad;

    @OneToMany(mappedBy = "idDuenio", cascade = CascadeType.ALL)
    private List<Mascota> mascotas = new ArrayList<>();

    public Duenio() {
    }

    public Duenio(int idDuenio, String nombre, String ciudad, String edad) {
        this.idDuenio = idDuenio;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.edad = edad;
    }

    public int getIdDuenio() {
        return idDuenio;
    }

    public void setIdDuenio(int idDuenio) {
        this.idDuenio = idDuenio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "\nDuenio{" +
                "idDuenio=" + idDuenio +
                ", nombre='" + nombre + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", edad='" + edad +
                '}';
    }
}
