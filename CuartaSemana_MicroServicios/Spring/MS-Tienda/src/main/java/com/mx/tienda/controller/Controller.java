package com.mx.tienda.controller;

import com.mx.tienda.dto.ClienteDto;
import com.mx.tienda.dto.DepartamentoDto;
import com.mx.tienda.dto.EmpleadoDto;
import com.mx.tienda.dto.ProductoDto;
import com.mx.tienda.entity.Tienda;
import com.mx.tienda.service.TiendasService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/tiendas")
public class Controller {

    @Autowired
    private TiendasService service;

    @GetMapping
    public ResponseEntity<?> listar(){
        List<Tienda> tiendas = service.listar();
        if(tiendas.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(tiendas);
    }

    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody Tienda tienda){
        service.guardar(tienda);
        return ResponseEntity.ok("La tienda se registro con exito");
    }

    @PutMapping
    public ResponseEntity<?> editar(@RequestBody Tienda tienda){
        Tienda existente = service.buscar(tienda.getIdTienda());
        if(existente == null){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("El id que quieres editar no existe");
        }
        service.editar(tienda);
        return ResponseEntity.ok("Edicion exitosa");
    }

    @DeleteMapping("/{idTienda}")
    public ResponseEntity<?> eliminar(@PathVariable int idTienda){
        Tienda existente = service.buscar(idTienda);
        if(existente == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El id que quieres eliminar no existe");
        }
        service.eliminar(idTienda);
        return ResponseEntity.ok("Se elimino la tienda");
    }

    @GetMapping("/{idTienda}")
    public ResponseEntity<?> buscar(@PathVariable int idTienda){
        Tienda existente = service.buscar(idTienda);
        if(existente == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El id que quieres buscar no existe");
        }
        return ResponseEntity.ok(existente);
    }

    /*Endpoint para visualizar los clientes de la tienda*/
    @GetMapping("/clientes/{tiendaId}")
    public ResponseEntity<?> listarClientes(@PathVariable int tiendaId){
        try{
            /*Buscaremos si existe la tienda*/
            Tienda tienda = service.buscar(tiendaId);
            if(tienda == null){
                return ResponseEntity.notFound().build();
            }else{
                /*Listar los clientes de esa tienda*/
                List<ClienteDto> clientes = service.listarClientes(tiendaId);
                if(clientes.isEmpty()){
                    return ResponseEntity.noContent().build();
                }else {
                    return ResponseEntity.ok(clientes);
                }
            }
        }catch (Exception e){
            /*Responde cuando el MS se encuentre apagado*/
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                    .body("El servicio de clientes no esta disponible");
        }
    }

    /*Endpoint para vizualizar los departamentos de la tienda*/
    @GetMapping("/departamentos/{tiendaId}")
    public ResponseEntity<?> listarDepartamentos(@PathVariable int tiendaId){
        try{
            Tienda tienda = service.buscar(tiendaId);
            if(tienda == null){
                return ResponseEntity.notFound().build();
            }else{
                List<DepartamentoDto> depas = service.listarDepas(tiendaId);
                if(depas.isEmpty()){
                    return ResponseEntity.noContent().build();
                }else{
                    return ResponseEntity.ok(depas);
                }
            }
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                    .body("El servicio de departamentos no esta disponible");
        }
    }

    /*Endpoint para vizualizar los empleados de la tienda*/
    @GetMapping("/empleados/{tiendaId}")
    public ResponseEntity<?> listarEmpleados(@PathVariable int tiendaId){
        try{
            Tienda tienda = service.buscar(tiendaId);
            if(tienda == null){
                return ResponseEntity.notFound().build();
            }else{
                List<EmpleadoDto> empleados = service.listarEmpleados(tiendaId);
                if(empleados.isEmpty()){
                    return ResponseEntity.noContent().build();
                }else{
                    return ResponseEntity.ok(empleados);
                }
            }
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                    .body("El servicio de empleados no esta disponible");
        }
    }

    /*Endpoint para vizualizar los empleados de la tienda*/
    @GetMapping("/productos/{tiendaId}")
    public ResponseEntity<?> listarProductos(@PathVariable int tiendaId){
        try{
            Tienda tienda = service.buscar(tiendaId);
            if(tienda == null){
                return ResponseEntity.notFound().build();
            }else{
                List<ProductoDto> productos = service.listarProductos(tiendaId);
                if(productos.isEmpty()){
                    return ResponseEntity.noContent().build();
                }else{
                    return ResponseEntity.ok(productos);
                }
            }
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                    .body("El servicio de productos no esta disponible");
        }
    }

    @GetMapping("/todo/{tiendaId}")
    public ResponseEntity<?> listarTodo(@PathVariable int tiendaId){
        Map<String, Object> listado = service.listarTodo(tiendaId);
        return ResponseEntity.ok(listado);
    }

}
