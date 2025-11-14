package com.examen.cajero.dominio;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TIPO_MONEDA")
public class TipoMoneda {

    @Id
    private int idTipoMoneda;
    private String nombre;

    @OneToMany(mappedBy = "tipoMonedaId", cascade = CascadeType.ALL)
    List<Denominacion> denominaciones =new ArrayList<>();

    public TipoMoneda() {
    }

    public TipoMoneda(int idTipoMoneda, String nombre) {
        this.idTipoMoneda = idTipoMoneda;
        this.nombre = nombre;
    }

    public int getIdTipoMoneda() {
        return idTipoMoneda;
    }

    public void setIdTipoMoneda(int idTipoMoneda) {
        this.idTipoMoneda = idTipoMoneda;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "TipoMoneda{" +
                "idTipoMoneda=" + idTipoMoneda +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
