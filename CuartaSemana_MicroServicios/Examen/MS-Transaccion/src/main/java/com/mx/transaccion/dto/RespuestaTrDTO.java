package com.mx.transaccion.dto;

import lombok.Data;

@Data
public class RespuestaTrDTO {
    private int idTransaccion;
    private String estatus;
    private String referencia;
    private String operacion;
}
