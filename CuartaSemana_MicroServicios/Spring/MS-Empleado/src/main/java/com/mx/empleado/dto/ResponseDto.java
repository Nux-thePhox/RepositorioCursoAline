package com.mx.empleado.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResponseDto {
    private int codigoRespuesta;
    private String mensaje;
    Object objJsonResponse;

    public ResponseDto(int codigoRespuesta, String mensaje) {
        this.codigoRespuesta = codigoRespuesta;
        this.mensaje = mensaje;
    }

    public ResponseDto(int codigoRespuesta){
        this.codigoRespuesta = codigoRespuesta;
    }
}
