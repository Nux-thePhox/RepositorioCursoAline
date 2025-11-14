package com.mx.libroprestamo.dominio;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "LIBRO")
public class Libro {
    @Id
    private int idLibro;
    private String nombre;
    private String autor;
    private String editorial;
    private Long isbn;

    @OneToMany(mappedBy = "libroId", cascade = CascadeType.ALL)
    List<Prestamo> prestamos = new ArrayList<>();

    public Libro() {
    }

    public Libro(int idLibro, String nombre, String autor, String editorial, Long isbn) {
        this.idLibro = idLibro;
        this.nombre = nombre;
        this.autor = autor;
        this.editorial = editorial;
        this.isbn = isbn;
    }

    public int getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public Long getIsbn() {
        return isbn;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "\nLibro{" +
                "idLibro=" + idLibro +
                ", nombre='" + nombre + '\'' +
                ", autor='" + autor + '\'' +
                ", editorial='" + editorial + '\'' +
                ", isbn=" + isbn +
                '}';
    }
}
