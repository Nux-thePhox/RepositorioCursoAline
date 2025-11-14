package com.mx.tienda.repository;

import com.mx.tienda.entity.Tienda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TiendasRepository extends JpaRepository<Tienda, Integer> {

}
