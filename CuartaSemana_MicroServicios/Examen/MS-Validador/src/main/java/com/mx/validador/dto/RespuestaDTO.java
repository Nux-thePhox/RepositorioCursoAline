package com.mx.validador.dto;

import lombok.Data;

@Data
public class RespuestaDTO {
    private int idTransaccion;
    private String estatus;
    private String referencia;
    private String operacion;
}

