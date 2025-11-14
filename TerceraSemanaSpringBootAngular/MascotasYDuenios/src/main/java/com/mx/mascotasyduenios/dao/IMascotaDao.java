package com.mx.mascotasyduenios.dao;

import com.mx.mascotasyduenios.dominio.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMascotaDao extends JpaRepository<Mascota, Integer> {

    @Query("SELECT m FROM Mascota m WHERE m.especie = :especie")
    List<Mascota> findActiveLoans(@Param("especie") String especieBuscada);
    //@Param especie debe empatar con el campo del query :especie
}
