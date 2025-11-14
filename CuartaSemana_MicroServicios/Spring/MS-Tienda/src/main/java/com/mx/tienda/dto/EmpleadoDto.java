package com.mx.tienda.dto;

import lombok.Data;

@Data
public class EmpleadoDto {
    private int idEmpleado;
    private String nombre;
    private String app;
    private String contacto;
    private int edad;
    private int tiendaId;
}
