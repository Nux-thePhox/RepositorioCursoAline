package com.mx.libroprestamo.dominio;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table
public class Prestamo {
    @Id
    private int idPrestamo;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "LIBRO_ID")
    private Libro libroId;

    public Prestamo() {
    }

    public Prestamo(Libro libroId, int idPrestamo, LocalDate fechaInicio, LocalDate fechaFin) {
        this.libroId = libroId;
        this.idPrestamo = idPrestamo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public Libro getLibroId() {
        return libroId;
    }

    public void setLibroId(Libro libroId) {
        this.libroId = libroId;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public int getIdPrestamo() {
        return idPrestamo;
    }

    public void setIdPrestamo(int idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    @Override
    public String toString() {
        return "\n Prestamo{" +
                "idPrestamo=" + idPrestamo +
                ", fechaInicio=" + fechaInicio +
                ", fechaFin=" + fechaFin +
                ", libroId=" + libroId +
                '}';
    }
}
