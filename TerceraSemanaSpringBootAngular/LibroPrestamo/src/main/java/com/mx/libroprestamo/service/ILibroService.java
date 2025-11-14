package com.mx.libroprestamo.service;

import com.mx.libroprestamo.dominio.Libro;

import java.util.List;

public interface ILibroService {
    List<Libro> listar();
    void guardar(Libro libro);
    void editar(Libro libro);
    Libro buscar(int idLibro);
    void eliminar(int idLibro);
}
