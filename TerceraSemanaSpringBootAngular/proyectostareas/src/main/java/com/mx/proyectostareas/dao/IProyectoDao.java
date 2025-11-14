package com.mx.proyectostareas.dao;

import com.mx.proyectostareas.dominio.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProyectoDao extends JpaRepository<Proyecto, Integer> {

    boolean existsByNombre(String nombre);

    @Query("SELECT p FROM Proyecto p WHERE p.estado = 'Activo' AND p.fechaFin < CURRENT_DATE")
    List<Proyecto> findProyectosVencidos();

    @Query("SELECT p FROM Proyecto p WHERE p.nombre = :nombre")
    List<Proyecto> findProyectosByNombre(@Param("nombre") String nombre);

}
