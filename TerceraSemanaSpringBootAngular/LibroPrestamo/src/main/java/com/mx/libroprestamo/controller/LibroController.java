package com.mx.libroprestamo.controller;

import com.mx.libroprestamo.dominio.Libro;
import com.mx.libroprestamo.service.LibroImplementacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "/libro")
public class LibroController {

    @Autowired
    LibroImplementacion libroService;

    //http://localhost:8003/libro

    //listar
    /*Response entity es una clase que sirve para modificar el estatus y el
    * body de la respuesta http*/
    @GetMapping("listar")
    public ResponseEntity<?> listar(){
        List<Libro> lista = libroService.listar();
        if(lista.isEmpty()){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.ok(lista);
    }

    //guardar
    @PostMapping("guardar")
    public ResponseEntity<?> guardar(@RequestBody Libro libro){
        boolean encontrado = libroService.existeLibro(libro.getNombre());
        if(encontrado){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Este libro ya existe en la BD");
        }else {
            libroService.guardar(libro);
            return ResponseEntity.status(HttpStatus.CREATED).body("Libro guardado");
        }
    }

    //editar
    @PostMapping("editar")
    public ResponseEntity<?> editar(@RequestBody Libro libro){
        Libro encontrado = libroService.buscar(libro.getIdLibro());
        if(encontrado == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El libro que deseas editar no existe ");
        } else{
            libroService.editar(libro);
            return ResponseEntity.ok("El "+ libro.getNombre()+" fue editado con exito");
        }
    }

    //buscar
    @GetMapping("buscar/{idLibro}")
    public ResponseEntity<?> buscar(@PathVariable int idLibro){
        Libro encontrado = libroService.buscar(idLibro);
        if(encontrado == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El libro que buscas no existe ");
        } else{
            return ResponseEntity.ok(encontrado);
        }
    }

    @DeleteMapping("eliminar/{idLibro}")
    public ResponseEntity<?> eliminar(@PathVariable int idLibro){
        Libro encontrado = libroService.buscar(idLibro);
        if(encontrado == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El libro que deseas eliminar no existe ");
        } else{
            libroService.eliminar(encontrado.getIdLibro());
            return ResponseEntity.ok("El libro "+encontrado.getNombre()+" se eliminó con exito");
        }
    }

}
