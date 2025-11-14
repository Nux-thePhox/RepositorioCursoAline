package com.mx.Celular.Dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mx.Celular.Dominio.Celular;

import java.util.List;

@Repository //se maneja por el contendor de bean de spring y esta puede ser inyectada en  otra clase
public interface ICelularDao extends CrudRepository<Celular, Integer> {
    //Mappea dentro de la base de datos para encontrar o llamar al procedimiento almacenado
    @Procedure(procedureName = "APLICAR_DESCUENTO")
    void aplicarDescuento(@Param("P_NUMERO")Integer pDescuento);

    @Query("SELECT c FROM Celular c WHERE c.marca = :marca")
    List<Celular> findCelularesByMarca(@Param("marca") String marca);

}
