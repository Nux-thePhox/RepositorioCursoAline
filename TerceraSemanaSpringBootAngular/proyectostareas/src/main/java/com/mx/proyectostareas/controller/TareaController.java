package com.mx.proyectostareas.controller;

import com.mx.proyectostareas.dominio.Tarea;
import com.mx.proyectostareas.service.TareaImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "/api/tareas")
public class TareaController {
    //http://localhost:8004/libros

    @Autowired
    private TareaImplement tareasService;

    @GetMapping
    public ResponseEntity<?> listarTareas(){
        List<Tarea> tareas = tareasService.listar();
        if(tareas.isEmpty()){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.ok(tareas);
    }

    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody Tarea tarea){
        Tarea encontrado = tareasService.buscarPorId(tarea.getIdTarea());
        if(encontrado != null){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Id ya existe en el registro");
        }else {
            if(tareasService.existeTituloTarea(tarea.getTitulo())){
                return ResponseEntity.status(HttpStatus.CONFLICT)
                        .body("El nombre de la tarea ya existe en el registro");
            }else{
                tareasService.guardar(tarea);
                return ResponseEntity.status(HttpStatus.CREATED).body("Tarea guardada");
            }
        }
    }

    @GetMapping("/{idTarea}")
    public ResponseEntity<?> buscar(@PathVariable int idTarea){
        Tarea encontrado = tareasService.buscarPorId(idTarea);
        if(encontrado != null){
            return ResponseEntity.ok(encontrado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping
    public ResponseEntity<?> editar(@RequestBody Tarea tarea){
        tareasService.editar(tarea);
        return ResponseEntity.ok("La Tarea se editó con exito");
    }

    @DeleteMapping("/{idTarea}")
    public ResponseEntity<?> eliminar(@PathVariable int idTarea){
        Tarea tarea = tareasService.buscarPorId(idTarea);
        if(tarea != null){
            tareasService.eliminarPorId(idTarea);
            return ResponseEntity.noContent().build();
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/vencidas")
    public ResponseEntity<?> listarTareasVencidas(){
        List<Tarea> tareas = tareasService.listarTareasVencidas();
        if(tareas.isEmpty()){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.ok(tareas);
    }
}
