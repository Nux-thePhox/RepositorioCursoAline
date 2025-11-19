package com.mx.validador.controller;

import com.mx.validador.dto.PeticionDTO;
import com.mx.validador.dto.RespuestaDTO;
import com.mx.validador.service.ValidadorService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/ms-validador")
public class ValidadorController {

    @Autowired
    ValidadorService service;

    @PostMapping
    public ResponseEntity<?> validandoPeticion(@Valid @RequestBody PeticionDTO peticion){
        log.info("Procesando petición: {}", peticion);
        RespuestaDTO respuesta = service.procesarPeticion(peticion);
        log.info("Consumo servicio: {}",respuesta);
        if(respuesta == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El codigo sha de la peticion es incorrecto.");
        }
        return ResponseEntity.ok(respuesta);
    }
}
