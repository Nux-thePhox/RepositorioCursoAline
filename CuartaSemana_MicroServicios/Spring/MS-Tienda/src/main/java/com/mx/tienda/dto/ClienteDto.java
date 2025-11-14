package com.mx.tienda.dto;

import lombok.Data;

@Data
public class ClienteDto {

    private int idCliente;
    private String nombre;
    private String app;
    private int edad;
    private int tiendaId;

}
