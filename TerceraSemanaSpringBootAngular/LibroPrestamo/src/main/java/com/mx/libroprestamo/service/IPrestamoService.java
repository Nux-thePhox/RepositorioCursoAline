package com.mx.libroprestamo.service;

import com.mx.libroprestamo.dominio.Prestamo;

import java.util.List;

public interface IPrestamoService {
    List<Prestamo> listar();
    void guardar(Prestamo prestamo);
    void editar(Prestamo prestamo);
    Prestamo buscar(int idPrestamo);
    void eliminar(int idPrestamo);
}
