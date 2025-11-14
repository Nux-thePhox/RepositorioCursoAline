package com.mx.empleado.repository;

import com.mx.empleado.entity.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpleadosRepository extends JpaRepository<Empleado, Integer> {
    boolean existsByNombreAndApp(String nombre, String app);
    boolean existsByContacto(String contacto);
    List<Empleado> findByTiendaId(int tiendaId);

}
