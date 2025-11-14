package com.mx.mascotasyduenios.service;

import com.mx.mascotasyduenios.dominio.Duenio;

import java.util.List;

public interface IDuenioService {
    List<Duenio> listar();
    void guardar(Duenio duenio);
    void editar(Duenio duenio);
    Duenio buscar(int idDuenio);
    void eliminar(int idDuenio);
}
