package com.mx.transaccion.service;

import com.mx.transaccion.dto.PeticionTrDTO;
import com.mx.transaccion.dto.RespuestaTrDTO;
import com.mx.transaccion.entity.Transaccion;
import com.mx.transaccion.repository.TransaccionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Slf4j
@Service
public class TransaccionService {

    @Autowired
    private TransaccionRepository repository;

    public RespuestaTrDTO guardarTransaccion(PeticionTrDTO trPeticion){
        Transaccion trAGuardar = new Transaccion();
        trAGuardar.setOperacion(trPeticion.getOperacion());
        trAGuardar.setImporte(trPeticion.getImporte());
        trAGuardar.setCliente(trPeticion.getCliente());
        trAGuardar.setReferencia(obtenReferencia());
        trAGuardar.setEstatus("Aprobada");
        repository.save(trAGuardar);

        if(trAGuardar.getIdTransaccion() != 0){
            RespuestaTrDTO trRespuesta = new RespuestaTrDTO();
            trRespuesta.setIdTransaccion(trAGuardar.getIdTransaccion());
            trRespuesta.setEstatus(trAGuardar.getEstatus());
            trRespuesta.setReferencia(trAGuardar.getReferencia());
            trRespuesta.setOperacion(trAGuardar.getOperacion());
            return trRespuesta;
        }
        log.error("Ocurrio una incidencia en la base de datos H2. No se ejecuto el metodo repository.save");
        return null;
    }

    private String obtenReferencia() {
        StringBuilder sb = new StringBuilder();
        int tamReferencia = 6;
        int minimo = 0;
        int maximo = 9;
        Random rand = new Random();
        int digitoAleatorio;
        for(int i = 0; i<tamReferencia; i++){
            digitoAleatorio = rand.nextInt(maximo - minimo + 1) + minimo;
            sb.append(digitoAleatorio);
        }
        return sb.toString();
    }

    public List<Transaccion> listarTransacciones(){
        return repository.findAll();
    }
}
