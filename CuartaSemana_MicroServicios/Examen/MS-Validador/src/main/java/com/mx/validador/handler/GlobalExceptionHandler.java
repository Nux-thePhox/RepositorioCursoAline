package com.mx.validador.handler;

import com.mx.validador.exception.HashGenerationException;
import com.mx.validador.exception.TransactionConsumoException;
import feign.RetryableException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    // Este método maneja específicamente las fallas de validación de @Valid
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidationExceptions(MethodArgumentNotValidException ex){
        //Mapa para almacenar los errores de los campos
        Map<String, String> errores = new HashMap<>();

        // Iteramos sobre todos los errores de campo que Spring capturó
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errores.put(error.getField(), error.getDefaultMessage());
        });

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errores);
    }

    //Este método maneja la falla del calculo sha512
    @ExceptionHandler(HashGenerationException.class)
    public ResponseEntity<String> handleHashGenerationException(HashGenerationException ex) {
        // Devuelve un error 500 con el mensaje de la excepción personalizada
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    //Este método manejara la falla con las respuestas no exitosas del http
    @ExceptionHandler(TransactionConsumoException.class)
    public ResponseEntity<String> handleTransactionConsumoException(TransactionConsumoException ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
    }

    //Meneja un fallo de conexión con el MS
    @ExceptionHandler(RetryableException.class)
    public ResponseEntity<String> handleRetryableException(RetryableException ex){
        log.info(" MS-Transaccion NO CONECCTION\n\t CAUSA: {} \n\t MESSAGE: {}", ex.getCause(), ex.getMessage());
        return new ResponseEntity<>("MS-Transaccion no está disponible", HttpStatus.SERVICE_UNAVAILABLE);
    }
}
