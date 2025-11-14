package com.mx.libroprestamo.controller;

import com.mx.libroprestamo.dominio.Prestamo;
import com.mx.libroprestamo.service.PrestamoImplementacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "/prestamos")
public class PrestamoController {

    @Autowired
    private PrestamoImplementacion prestamoService;

    @GetMapping
    public ResponseEntity<?> listar(){
        List<Prestamo> prestamos = prestamoService.listar();
        if(prestamos.isEmpty()){
            return ResponseEntity
                    .status(HttpStatus.NO_CONTENT)
                    .body("No hay prestamos Registrados");
        } else{
            return ResponseEntity.ok(prestamos);
        }
    }

    @PostMapping("/guardarprestamo")
    public ResponseEntity<?> guardar(@RequestBody Prestamo prestamo){
        Prestamo nuevoPrestamo = prestamoService.buscar(prestamo.getIdPrestamo());
        if(nuevoPrestamo != null){
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body("El prestamo "+prestamo.getIdPrestamo()+" ya fue registrado");
        }else {
            prestamoService.guardar(prestamo);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body("El prestamo "+prestamo.getIdPrestamo()+"se registró con exito");
        }
    }

    @GetMapping("/{idPrestamo}")
    public ResponseEntity<?> buscar(@PathVariable int idPrestamo){
        Prestamo encontrado = prestamoService.buscar(idPrestamo);
        if(encontrado != null){
            return ResponseEntity.ok(encontrado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{idPrestamo}")
    public ResponseEntity<?> eliminar(@PathVariable int idPrestamo){
        Prestamo prestamo = prestamoService.buscar(idPrestamo);
        if(prestamo != null){
            prestamoService.eliminar(idPrestamo);
            return ResponseEntity.noContent().build();
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping
    public ResponseEntity<?> editar(@RequestBody Prestamo prestamo){
        prestamoService.editar(prestamo);
        return ResponseEntity.ok("El prestamo se editó con exito");
    }

    //activos
    @GetMapping("/activo")
    public ResponseEntity<?> obtenerActivos(){
        List<Prestamo> activos = prestamoService.obtenerPrestamosActivos();
        if(activos.isEmpty()){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok(activos);
        }
    }

    @PutMapping("/{idPrestamo}/fechafin")
    public ResponseEntity<?> actualizarFechas(@PathVariable int idPrestamo, @RequestBody LocalDate fechaFin){
        boolean actualizacion = prestamoService.actualizarFechaFin(idPrestamo, fechaFin);
        if(actualizacion){
            return ResponseEntity.ok("Fecha aztualizada");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Prestamo no encontrado, no se pudo actualizar");
    }
}

