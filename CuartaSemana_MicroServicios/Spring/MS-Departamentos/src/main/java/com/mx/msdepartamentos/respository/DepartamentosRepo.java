package com.mx.msdepartamentos.respository;

import com.mx.msdepartamentos.entity.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartamentosRepo extends JpaRepository<Departamento, Integer> {

    List<Departamento> findByTiendaId(int tiendaId);
    boolean existsByNombreAllIgnoringCase(String nombre);

}
