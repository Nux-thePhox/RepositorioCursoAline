package com.mx.mascotasyduenios.controller;

import com.mx.mascotasyduenios.dominio.Duenio;
import com.mx.mascotasyduenios.service.DuenioImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "/duenios")
public class DuenioController {

    @Autowired
    DuenioImplement duenioImplement;

    //http://localhost:8002/duenios

    @GetMapping
    public ResponseEntity<?> listar(){
        List<Duenio> lista = duenioImplement.listar();
        if(lista.isEmpty()){
            return ResponseEntity.status(HttpStatus.NO_CONTENT)
                    .body("No hay duenios registrados");
        }
        return ResponseEntity.ok(lista);
    }

    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody Duenio duenio){
        Duenio nuevoDuenio = duenioImplement.buscar(duenio.getIdDuenio());
        if(nuevoDuenio != null){
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body("El duenio "+duenio.getIdDuenio()+" ya fue registrado");
        }else {
            duenioImplement.guardar(duenio);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body("El duenio "+duenio.getIdDuenio()+"se registró con exito");
        }
    }

    @GetMapping("/{idDuenio}")
    public ResponseEntity<?> buscar(@PathVariable int idDuenio){
        Duenio encontrado = duenioImplement.buscar(idDuenio);
        if(encontrado != null){
            return ResponseEntity.ok(encontrado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping
    public ResponseEntity<?> editar(@RequestBody Duenio duenio){
        duenioImplement.editar(duenio);
        return ResponseEntity.ok("El duenio se editó con exito");
    }

    @DeleteMapping("/{idDuenio}")
    public ResponseEntity<?> eliminar(@PathVariable int idDuenio){
        Duenio duenio = duenioImplement.buscar(idDuenio);
        if(duenio != null){
            duenioImplement.eliminar(idDuenio);
            return ResponseEntity.noContent().build();
        }else {
            return ResponseEntity.notFound().build();
        }
    }
}
