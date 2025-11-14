package com.mx.proyectostareas.service;

import com.mx.proyectostareas.dominio.Tarea;

import java.util.List;

public interface TareasService {
    List<Tarea> listar();
    void guardar(Tarea tarea);
    void editar(Tarea tarea);
    Tarea buscarPorId(int idTarea);
    void eliminarPorId(int idTarea);
}
