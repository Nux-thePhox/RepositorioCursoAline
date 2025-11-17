package com.mx.validador.exception;


/*
* Exception personalizada para manejar una respuesta Http por si ocurre un fallo en el calculo de sha-512*/
public class HashGenerationException extends RuntimeException{

    public HashGenerationException(String message, Throwable cause){
        super(message, cause);
    }
}
