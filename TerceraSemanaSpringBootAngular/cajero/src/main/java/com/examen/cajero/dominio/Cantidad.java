package com.examen.cajero.dominio;

import jakarta.persistence.*;

@Entity
@Table(name = "FONDOS_DISPONIBLES")
public class Cantidad {

    @Id
    private int idFondosDisponibles;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "DENOMINACION_ID")
    private Denominacion denominacionId;
    private int cantidad;

    public Cantidad() {
    }

    public Cantidad(int idFondosDisponibles, Denominacion denominacionId, int cantidad) {
        this.idFondosDisponibles = idFondosDisponibles;
        this.denominacionId = denominacionId;
        this.cantidad = cantidad;
    }

    public int getIdFondosDisponibles() {
        return idFondosDisponibles;
    }

    public void setIdFondosDisponibles(int idFondosDisponibles) {
        this.idFondosDisponibles = idFondosDisponibles;
    }

    public Denominacion getDenominacionId() {
        return denominacionId;
    }

    public void setDenominacionId(Denominacion denominacionId) {
        this.denominacionId = denominacionId;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "FondosDisponibles{" +
                "idFondosDisponibles=" + idFondosDisponibles +
                ", denominacionId=" + denominacionId +
                ", cantidad=" + cantidad +
                '}';
    }
}
