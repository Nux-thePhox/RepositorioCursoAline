package com.mx.tienda.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table
public class Tienda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTienda;
    private String nombre;
    private String direccion;
    private Long contacto;

}
