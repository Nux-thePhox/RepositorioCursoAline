package com.mx.tienda.dto;

import lombok.Data;

@Data
public class DepartamentoDto {
    private int idDepartamento;
    private String nombre;
    private String encargado;
    private int tiendaId;
}
