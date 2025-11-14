package com.mx.mascotasyduenios.dao;

import com.mx.mascotasyduenios.dominio.Duenio;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDuenioDao extends JpaRepository<Duenio, Integer> {

}
