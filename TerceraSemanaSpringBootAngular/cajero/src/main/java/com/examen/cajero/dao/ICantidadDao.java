package com.examen.cajero.dao;

import com.examen.cajero.dominio.Denominacion;
import com.examen.cajero.dominio.Cantidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

@Repository
public interface ICantidadDao extends JpaRepository<Cantidad, Integer> {

    @Procedure(procedureName = "CONSIGUE_FONDO_TOTAL_CAJERO")
    float obtenFondoTotal();

    Cantidad findByDenominacionId(Denominacion denominacionABuscar);
}
