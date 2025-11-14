package com.mx.libroprestamo.dao;

import com.mx.libroprestamo.dominio.Prestamo;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IPrestamoDao extends JpaRepository<Prestamo, Integer> {

    //Consultar los prestamos activos o que no tengan fecha de entrega
    @Query("SELECT p FROM Prestamo p WHERE p.fechaFin IS NULL OR p.fechaFin > :fechaActual")
    List<Prestamo> findActiveLoans(@Param("fechaActual") LocalDate fechaActual);

    /*
    * jpql -> Java Persistence Query Lenguage
    * :fechaActual, es la sintaxis para ingresar nuestras variables o argumentos en la consulta
    * @Query es una anotacion que define una consulta jpql personalizada
    * SELECT p FROM PRESTAMO WHERE p : seleccionando todo de la tabla prestamo
    * p.FECHA_FIN IS NULL OR p.FECHA_FIN > :fechaActual -> filtra para conseguir los prestamos activos
    * list<> -> nos retornara en lista los objetos que coincidan con el filtro */


    //Crear un metodo que me edite la fecha de fin
    @Modifying //indica que es una operacion de alteracion
    @Transactional //provee un contexto de transaccion necesaria
    @Query("UPDATE Prestamo p SET p.fechaFin = :fechaFin WHERE p.idPrestamo = idPrestamo")
    int actualizarFechaFin(@Param("idPrestamo") int idPrestamo, @Param("fechaFin") LocalDate fechaFin);

}
