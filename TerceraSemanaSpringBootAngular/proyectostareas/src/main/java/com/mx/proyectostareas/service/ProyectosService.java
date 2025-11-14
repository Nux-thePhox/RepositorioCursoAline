package com.mx.proyectostareas.service;

import com.mx.proyectostareas.dominio.Proyecto;

import java.util.List;

public interface ProyectosService {
    List<Proyecto> listar();
    void guardar(Proyecto proyecto);
    void editar(Proyecto proyecto);
    Proyecto buscarPorId(int idProyecto);
    void eliminarPorId(int idProyecto);
}
