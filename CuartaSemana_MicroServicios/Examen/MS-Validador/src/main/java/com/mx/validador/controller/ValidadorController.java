package com.mx.validador.controller;

import com.mx.validador.dto.PeticionDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/ms-validador")
public class ValidadorController {

    @GetMapping
    public ResponseEntity<?> validandoPeticion(@Valid @RequestBody PeticionDTO peticion){
        System.out.println("Peticion recibida: "+peticion);
        return ResponseEntity.ok("Validando datos generales de la petición");
    }
}
