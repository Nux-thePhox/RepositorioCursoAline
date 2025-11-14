package com.mx.mscliente.repository;

import com.mx.mscliente.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    List<Cliente> findByTiendaId(int tiendaId);
    boolean existsByNombreAndAppAllIgnoringCase(String nombre, String app);
}
