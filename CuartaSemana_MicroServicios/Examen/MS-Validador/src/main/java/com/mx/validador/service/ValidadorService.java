package com.mx.validador.service;

import com.mx.validador.dto.PeticionDTO;
import com.mx.validador.dto.RespuestaDTO;
import com.mx.validador.exception.HashGenerationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Slf4j
@Service
public class ValidadorService {

    public RespuestaDTO procesarPeticion(PeticionDTO peticion){
        if(validaSha(peticion)){
            log.info("Persistiendo peticion de transaccion");
            return null;
        }
        log.info("El codigo sha de la peticion es incorrecto.");
        return null;
    }

    public boolean validaSha(PeticionDTO peticion){
        try{
            // Obtiene una instancia de MessageDigest para el algoritmo SHA-512
            MessageDigest digest = MessageDigest.getInstance("SHA-512");

            String cadenaConcatenada = peticion.getOperacion().concat(peticion.getImporte());
            cadenaConcatenada = cadenaConcatenada.concat(peticion.getCliente());
            log.info("concatenacion: {}", cadenaConcatenada);

            // Calcula el hash de la cadena de entrada (convertida a bytes usando UTF-8)
            byte[] hashBytes = digest.digest(cadenaConcatenada.getBytes(StandardCharsets.UTF_8));

            //Convierte el array resultante a una representación exadecimal
            StringBuilder hexString = new StringBuilder();

            for(byte b: hashBytes){
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1){
                    // Asegura que cada byte se represente con dos caracteres hexadecimales
                    hexString.append('0');
                }
                hexString.append(hex);
            }

            log.info("SHA recibido: {}", peticion.getSha());
            log.info("SHA esperado: {}", hexString);
            log.info(" validación SHA: {}", peticion.getSha().contentEquals(hexString));
            return peticion.getSha().contentEquals(hexString);
        }catch (NoSuchAlgorithmException e){
            log.error("El algoritmo SHA-512 no se encuentra disponible: {}", e.getMessage());
            throw new HashGenerationException("Error al generar el hash SHA-512. Algoritmo no disponible.", e);
        }
    }
}
