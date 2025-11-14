package com.examen.cajero.controller;

import com.examen.cajero.dominio.Cantidad;

import com.examen.cajero.service.impl.CajeroImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "/cajero")
public class CajeroController {

    @Autowired
    CajeroImpl fondosDisponibles;

    @GetMapping
    public ResponseEntity<?> muestraFondosTotal(){
        return ResponseEntity.ok(fondosDisponibles.obtenFondoTotal());
    }

    @GetMapping("/retiro")
    public ResponseEntity<?> retiraMonto(@RequestParam float monto){
        float fondoTotal = fondosDisponibles.obtenFondoTotal();
        if(monto > fondoTotal){
            return ResponseEntity.status(HttpStatus.PAYMENT_REQUIRED).body("Fondos insuficientes para completar " +
                    "la transacción. Ingresa un monto menor o asiste a otro cajero ");
        }else{

            List<Cantidad> denominacionesARetirar = fondosDisponibles.obtenDenominacionParaRetirar(monto);

            //Se devuelve la moneda y la cantidad a retirar
            return ResponseEntity.ok(denominacionesARetirar);
        }
    }

    @GetMapping("/monedasmanejadas")
    public ResponseEntity<?> obtenTipoMonedaEnCajero(){
        return ResponseEntity.ok(fondosDisponibles.obtenMonedas());
    }

    @GetMapping("/denominacionesmanejadas")
    public ResponseEntity<?> obtenDenominacionesEnCajero(){
        return ResponseEntity.ok(fondosDisponibles.obtenDenominaciones());
    }
}
