package com.mx.msdepartamentos.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table
public class Departamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDepartamento;
    private String nombre;
    private String encargado;
    private int tiendaId;

}
