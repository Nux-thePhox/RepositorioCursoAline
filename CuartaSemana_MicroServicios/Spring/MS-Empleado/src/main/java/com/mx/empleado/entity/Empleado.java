package com.mx.empleado.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Table
@Entity
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEmpleado;
    private String nombre;
    private String app;
    private String contacto;
    private int edad;
    private int tiendaId;

}
