package com.examen.cajero.dao;

import com.examen.cajero.dominio.Denominacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDenominacionDao extends JpaRepository<Denominacion, Integer> {
    Denominacion findByValor(float valor);
}
