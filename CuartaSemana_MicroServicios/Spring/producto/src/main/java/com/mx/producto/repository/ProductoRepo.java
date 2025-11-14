package com.mx.producto.repository;

import com.mx.producto.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepo extends JpaRepository<Producto, Integer> {
    List<Producto> findByTiendaId(int tiendaId);
}
