package com.mx.tienda.dto;

import lombok.Data;

@Data
public class ProductoDto {
    private int idProducto;
    private String nombre;
    private String tipo;
    private String caracteristicas;
    private double precio;
    private int stock;
    private int tiendaId;
}
