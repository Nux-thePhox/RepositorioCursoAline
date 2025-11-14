package com.mx.mscliente.controller;

import com.mx.mscliente.entity.Cliente;
import com.mx.mscliente.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/Clientes")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @GetMapping
    public ResponseEntity<?> listar(){
        List<Cliente> lista = service.listAllClientes();
        if (lista.isEmpty()){
            return ResponseEntity.noContent().build();
        }else {
            return ResponseEntity.ok(lista);
        }
    }

    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody Cliente cliente){
        boolean existe = service.existsCliente(cliente.getNombre(), cliente.getApp());
        if(existe){
            return ResponseEntity.status(HttpStatus.FOUND).body("El cliente "+cliente.getNombre()+ " "+cliente.getApp()
                    + " ya esta registrado en el sistema");
        }else{
            service.save(cliente);
            return ResponseEntity.status(HttpStatus.CREATED).body("El cliente "+cliente.getNombre()+" "+cliente.getApp()
                    + " se registro con exito");
        }
    }

    @PutMapping
    public ResponseEntity<?> editar(@RequestBody Cliente cliente){
        System.out.println("Buscando cliente: "+cliente.getIdCliente());
        Cliente clienteBD = service.findCliente(cliente.getIdCliente());
        if(clienteBD != null){
            System.out.println("Cliente encontrado");
            System.out.println("El nombre es el mismo ??.... "+service.nuevoNombreEsElMismo(cliente, clienteBD));
            if(service.nuevoNombreEsElMismo(cliente, clienteBD)){
                service.update(cliente);
                return ResponseEntity.ok().body("Se actualizo con exito");
            }else{
                boolean existe = service.existsCliente(cliente.getNombre(), cliente.getApp());
                if(existe){
                    return ResponseEntity.status(HttpStatus.FOUND).body("El nombre "+cliente.getNombre()
                            +" "+cliente.getApp() + " ya esta registrado en el sistema");
                }else{
                    service.update(cliente);
                    return ResponseEntity.ok().body("Se actualizo con exito");
                }
            }
        }else {
            System.out.println("Cliente no encontrado");
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{idCliente}")
    public ResponseEntity<?> buscar(@PathVariable int idCliente){
        Cliente encontrado = service.findCliente(idCliente);
        if(encontrado == null){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok(encontrado);
        }
    }

    @DeleteMapping("eliminar/{idCliente}")
    public ResponseEntity<?> eliminar(@PathVariable int idCliente){
        Cliente eCliente = service.findCliente(idCliente);
        if(eCliente != null){
            service.delete(idCliente);
            return ResponseEntity.ok("El cliente fue eliminado de la base de datos");
        }else{
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Nose puede eliminar porque no esta registrado en la base de datos");
        }
    }

    //listar por tienda
    @GetMapping("buscarPorTienda/{tiendaId}")
    public ResponseEntity<?> buscarPorTienda(@PathVariable int tiendaId){
        List<Cliente> clientes = service.findByTienda(tiendaId);
        return ResponseEntity.ok(clientes);
    }
}
