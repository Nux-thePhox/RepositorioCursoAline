package com.mx.proyectostareas.dominio;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "TAREAS")
public class Tarea {

    @Id
    private int idTarea;
    private String titulo;
    private String descripcion;
    private String estudianteAsignado;
    private LocalDate fechaCreacion;
    private LocalDate fechaVencimiento;
    private String estado;
    private String prioridad;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "PROYECTO_ID")
    private Proyecto proyectoId;

    public Tarea() {
    }

    public Tarea(int idTarea, String titulo, String descripcion, String estudianteAsignado, LocalDate fechaCreacion,
                 LocalDate fechaVencimiento, String estado, String prioridad, Proyecto proyectoId) {
        this.idTarea = idTarea;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.estudianteAsignado = estudianteAsignado;
        this.fechaCreacion = fechaCreacion;
        this.fechaVencimiento = fechaVencimiento;
        this.estado = estado;
        this.prioridad = prioridad;
        this.proyectoId = proyectoId;
    }

    public int getIdTarea() {
        return idTarea;
    }

    public void setIdTarea(int idTarea) {
        this.idTarea = idTarea;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstudianteAsignado() {
        return estudianteAsignado;
    }

    public void setEstudianteAsignado(String estudianteAsignado) {
        this.estudianteAsignado = estudianteAsignado;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public Proyecto getProyectoId() {
        return proyectoId;
    }

    public void setProyectoId(Proyecto proyectoId) {
        this.proyectoId = proyectoId;
    }

    @Override
    public String toString() {
        return "\nsTarea{" +
                "idTarea=" + idTarea +
                ", titulo='" + titulo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", estudianteAsignado='" + estudianteAsignado + '\'' +
                ", fechaCreacion=" + fechaCreacion +
                ", fechaVencimiento=" + fechaVencimiento +
                ", estado='" + estado + '\'' +
                ", prioridad='" + prioridad + '\'' +
                ", proyectoId=" + proyectoId +
                '}';
    }
}
