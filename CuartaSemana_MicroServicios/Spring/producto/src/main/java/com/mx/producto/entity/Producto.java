package com.mx.producto.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProducto;
    private String nombre;
    private String tipo;
    private String caracteristicas;
    private double precio;
    private int stock;
    private int tiendaId;

}
