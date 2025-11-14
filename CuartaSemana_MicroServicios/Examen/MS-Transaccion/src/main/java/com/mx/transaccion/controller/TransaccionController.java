package com.mx.transaccion.controller;

import com.mx.transaccion.dto.PeticionTrDTO;
import com.mx.transaccion.dto.RespuestaTrDTO;
import com.mx.transaccion.entity.Transaccion;
import com.mx.transaccion.service.TransaccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ms-transaccion")
public class TransaccionController {

    @Autowired
    private TransaccionService service;

    @GetMapping
    public ResponseEntity<?> listarTransacciones(){
        List<Transaccion> listaTransacciones = service.listarTransacciones();
        if(listaTransacciones.isEmpty()){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.ok(listaTransacciones);
    }

    @PostMapping
    public ResponseEntity<?> guardarTransaccion(@RequestBody PeticionTrDTO trPeticion){
        RespuestaTrDTO trAprobada = service.guardarTransaccion(trPeticion);
        if(trAprobada == null){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("No persistió la transaccion en la BD");
        }
        return ResponseEntity.ok().body(trAprobada);
    }
}
