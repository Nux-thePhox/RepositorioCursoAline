package com.mx.proyectostareas.controller;

import com.mx.proyectostareas.dominio.Proyecto;
import com.mx.proyectostareas.service.ProyectoImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "/api/proyectos")
public class ProyectoController {

    //http://localhost:8004/proyectos

    @Autowired
    private ProyectoImplement proyectoService;

    @GetMapping
    public ResponseEntity<?> listarProyectos(){
        List<Proyecto> proyectos = proyectoService.listar();
        if(proyectos.isEmpty()){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.ok(proyectos);
    }

    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody Proyecto proyecto){
        Proyecto encontrado = proyectoService.buscarPorId(proyecto.getIdProyecto());
        if(encontrado != null){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Id ya existe en el registro");
        }else {
            if(proyectoService.existeNombreProyecto(proyecto.getNombre())){
                return ResponseEntity.status(HttpStatus.CONFLICT)
                        .body("El nombre del proyecto ya existe en el registro");
            }else{
                proyectoService.guardar(proyecto);
                return ResponseEntity.status(HttpStatus.CREATED).body("Proyecto guardado");
            }
        }
    }

    @GetMapping("/{idProyecto}")
    public ResponseEntity<?> buscar(@PathVariable int idProyecto){
        Proyecto encontrado = proyectoService.buscarPorId(idProyecto);
        if(encontrado != null){
            return ResponseEntity.ok(encontrado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping
    public ResponseEntity<?> editar(@RequestBody Proyecto proyecto){
        proyectoService.editar(proyecto);
        return ResponseEntity.ok("El proyecto se editó con exito");
    }

    @DeleteMapping("/{idProyecto}")
    public ResponseEntity<?> eliminar(@PathVariable int idProyecto){
        Proyecto proyecto = proyectoService.buscarPorId(idProyecto);
        if(proyecto != null){
            proyectoService.eliminarPorId(idProyecto);
            return ResponseEntity.noContent().build();
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/vencidos")
    public ResponseEntity<?> obtenProyectosVencidos(){
        List<Proyecto> proyectos = proyectoService.findProyectosVencidos();
        if(proyectos.isEmpty()){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.ok(proyectos);
    }

    @GetMapping("/buscar/nombre/{nombre}")
    public ResponseEntity<?> obtenProyectosByNombre(@PathVariable String nombre){
        List<Proyecto> proyectos = proyectoService.findProyectosByNombre(nombre);
        if(proyectos.isEmpty()){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.ok(proyectos);
    }
}
