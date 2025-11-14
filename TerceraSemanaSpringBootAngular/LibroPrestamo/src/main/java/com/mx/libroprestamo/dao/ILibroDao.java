package com.mx.libroprestamo.dao;

import com.mx.libroprestamo.dominio.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILibroDao extends JpaRepository<Libro, Integer> {

    boolean existsByNombre(String nombre);

}
