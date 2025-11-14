package com.mx.proyectostareas.dao;

import com.mx.proyectostareas.dominio.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITareaDao extends JpaRepository<Tarea, Integer> {
    boolean existsByTitulo(String nombre);

    @Query("SELECT t FROM Tarea t WHERE t.estado = 'Pendiente' AND t.fechaVencimiento < CURRENT_DATE")
    List<Tarea> findTareassVencidos();
}
