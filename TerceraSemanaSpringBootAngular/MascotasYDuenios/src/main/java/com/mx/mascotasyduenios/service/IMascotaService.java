package com.mx.mascotasyduenios.service;

import com.mx.mascotasyduenios.dominio.Mascota;

import java.util.List;

public interface IMascotaService {
    List<Mascota> listar();
    void guardar(Mascota mascota);
    void editar(Mascota mascota);
    Mascota buscar(int idMascota);
    void eliminar(int idMascota);
}
