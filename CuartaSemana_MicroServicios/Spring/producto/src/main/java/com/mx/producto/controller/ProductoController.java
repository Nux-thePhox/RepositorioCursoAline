package com.mx.producto.controller;

import com.mx.producto.entity.Producto;
import com.mx.producto.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Productos")
public class ProductoController {

    @Autowired
    private ProductoService service;

    @GetMapping
    public ResponseEntity<?> listar(){
        List<Producto> productos = service.listar();
        if(productos.isEmpty()){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok(productos);
        }
    }

    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody Producto producto){
        service.guardar(producto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("El Producto "+producto.getNombre() + " se registro");
    }

    @PutMapping
    public ResponseEntity<?> editar(@RequestBody Producto productoNuevo){
        Producto productoAnterior = service.buscar(productoNuevo.getIdProducto());
        if(productoAnterior == null){
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("No se puede editar, el producto no está registrao");
        }else{
            service.editar(productoNuevo);
            return ResponseEntity.accepted().body("El producto se edito con exito");
        }
    }

    @DeleteMapping("/{idProducto}")
    public ResponseEntity<?> eliminar (@PathVariable int idProducto){
        Producto pro = service.buscar(idProducto);
        if(pro != null){
            service.eliminar(idProducto);
            return ResponseEntity.ok("Eliminación exitosa");
        }else{
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("No se puede eliminar, el id no existe en la BD");
        }
    }

    @GetMapping("/{idProducto}")
    public ResponseEntity<?> buscar(@PathVariable int idProducto){
        Producto producto = service.buscar(idProducto);
        if(producto !=  null){
            return ResponseEntity.ok(producto);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encuentra registrado el id "+idProducto+"en la base de datos");
        }
    }

    @GetMapping("/listarPorTienda/{tiendaId}")
    public ResponseEntity<?> listarPorTienda(@PathVariable int tiendaId){
        List<Producto> productos = service.listarPorTienda(tiendaId);
        if(productos.isEmpty()){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok(productos);
        }
    }
}
