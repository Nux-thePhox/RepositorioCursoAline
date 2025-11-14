package com.mx.msdepartamentos.controller;

import com.mx.msdepartamentos.entity.Departamento;
import com.mx.msdepartamentos.service.ServiceDepartamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//No se ocupa CrossOrigin porque  CorsFilter
//@CrossOrigin
@RestController
@RequestMapping("/Departamentos")
public class DepartamentoController {

    @Autowired
    private ServiceDepartamento service;

    @GetMapping
    private ResponseEntity<?> listar(){
        List<Departamento> depas = service.listar();
        if(depas.isEmpty()){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok(depas);
        }
    }

    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody Departamento departamento){
        boolean existente = service.existeDepartamento(departamento.getNombre());
        if(existente){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Error, Este departamento ya está registrado");
        }else{
            service.guardar(departamento);
            return ResponseEntity.status(HttpStatus.CREATED).body("Departamento creado");
        }
    }

    @PutMapping
    public ResponseEntity<?> editar(@RequestBody Departamento departamento){
        Departamento depa = service.buscar(departamento.getIdDepartamento());
        if(depa != null){
            service.editar(departamento);
            return ResponseEntity.accepted().body("Edicion exitosa");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El registro que intentas editar no existe");
        }
    }

    @DeleteMapping("/{idDepartamento}")
    public ResponseEntity<?> eliminar(@PathVariable int idDepartamento){
        Departamento existeDepartamento = service.buscar(idDepartamento);
        if(existeDepartamento == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El registro que intentas eliminar no existe");
        }else{
            service.eliminar(idDepartamento);
            return ResponseEntity.ok().body("Eliminación exitosa");
        }
    }

    @GetMapping("/{idDepartamento}")
    public ResponseEntity<?> buscar(@PathVariable int idDepartamento){
        Departamento depa = service.buscar(idDepartamento);
        if(depa == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("El registro no existe");
        }else{
            return ResponseEntity.ok(depa);
        }
    }

    @GetMapping("porTiendas/{tiendaId}")
    public ResponseEntity<?> buscarPorTienda(@PathVariable int tiendaId){
        List<Departamento> depas = service.listarPorDepa(tiendaId);
        return ResponseEntity.ok(depas);
    }
}
