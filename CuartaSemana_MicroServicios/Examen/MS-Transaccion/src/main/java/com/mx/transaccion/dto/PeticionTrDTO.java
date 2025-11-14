package com.mx.transaccion.dto;

import lombok.Data;

@Data
public class PeticionTrDTO {
    private String operacion;
    private String importe;
    private String cliente;
}
