package com.mx.validador.errordecoder;

import com.mx.validador.exception.TransactionConsumoException;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpStatus;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

/*
* Esta clase manejara las respuestas 400 que nos lanse el consumo del MS-Transaccion*/
public class TransaccionErrorDecoder implements ErrorDecoder {

    private final ErrorDecoder defaultDecoder = new Default();

    @Override
    public Exception decode(String methodKey, Response response) {
        if(response.status() == HttpStatus.CONFLICT.value()){ //409 Conflict
            try(InputStream bodyIs = response.body().asInputStream()){
                String message = IOUtils.toString(bodyIs, StandardCharsets.UTF_8);
                //lanza la exception personalizada
                return new TransactionConsumoException(message);
            } catch(IOException e){
                //Si falla la lectura
                return new RuntimeException("Error al leer el mensaje HTTP CONFLICT");
            }
        }
        // Para otros códigos de error, usa el decodificador por defecto de Feign
        return defaultDecoder.decode(methodKey, response);
    }
}
