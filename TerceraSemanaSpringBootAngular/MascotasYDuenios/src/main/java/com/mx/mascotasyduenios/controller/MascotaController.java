package com.mx.mascotasyduenios.controller;

import com.mx.mascotasyduenios.dominio.Mascota;
import com.mx.mascotasyduenios.service.MascotaImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "/mascotas")
public class MascotaController {

    //http://localhost:8002/mascotas

    @Autowired
    private MascotaImplement mascotaImplement;

    @GetMapping
    public ResponseEntity<?> listar(){
        List<Mascota> mascotas = mascotaImplement.listar();
        if(mascotas.isEmpty()){
            return ResponseEntity
                    .status(HttpStatus.NO_CONTENT)
                    .body("No hay mascotas Registradas");
        } else{
            return ResponseEntity.ok(mascotas);
        }
    }

    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody Mascota mascota){
        Mascota nuevaMascota = mascotaImplement.buscar(mascota.getIdMascota());
        if(nuevaMascota != null){
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body("La mascota "+mascota.getIdMascota()+" ya fue registrada");
        }else {
            mascotaImplement.guardar(mascota);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body("La mascota "+mascota.getIdMascota()+"se registró con exito");
        }
    }

    @GetMapping("/{idMascota}")
    public ResponseEntity<?> buscar(@PathVariable int idMascota){
        Mascota encontrado = mascotaImplement.buscar(idMascota);
        if(encontrado != null){
            return ResponseEntity.ok(encontrado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{idMascota}")
    public ResponseEntity<?> eliminar(@PathVariable int idMascota){
        Mascota prestamo = mascotaImplement.buscar(idMascota);
        if(prestamo != null){
            mascotaImplement.eliminar(idMascota);
            return ResponseEntity.noContent().build();
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping
    public ResponseEntity<?> editar(@RequestBody Mascota mascota){
        mascotaImplement.editar(mascota);
        return ResponseEntity.ok("La mascota se editó con exito");
    }

    @GetMapping("/especie/{especieBuscada}")
    public ResponseEntity<?> listarPorEspecie(@PathVariable String especieBuscada){
        List<Mascota> mascotas = mascotaImplement.listarPorEspecie(especieBuscada);
        if(mascotas.isEmpty()){
            return ResponseEntity
                    .status(HttpStatus.NO_CONTENT)
                    .body("No hay mascotas Registradas con esa raza");
        } else{
            return ResponseEntity.ok(mascotas);
        }
    }
}
