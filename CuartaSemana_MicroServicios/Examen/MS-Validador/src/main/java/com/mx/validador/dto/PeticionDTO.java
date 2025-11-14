package com.mx.validador.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class PeticionDTO {

    //debe ser alfabetico, longitud maxima 15
    @NotBlank(message = "La operacion no puede ir vacia")
    @Size(max = 15, message = "La longitud máxima de la operacion es de 15 caracteres")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "La operacion debe contener solo caracteres alfabeticos")
    private String operacion;

    //deben ser numeros, en formato moneda, con dos digitos decimales
    @NotBlank(message = "El importe no puede estar vacío.")
    // Esta expresión regular permite:
    // ^\\d+          -> Uno o más dígitos al inicio (parte entera)
    // (\\.\\d{2})?   -> Opcionalmente (?), un punto (\.) seguido de exactamente dos dígitos (\d{2})
    // $              -> Fin de la cadena
    @Pattern(
            regexp = "^\\d+(\\.\\d{2})?$",
            message = "El importe debe tener un formato numérico válido (ej: 100 o 100.50)"
    )
    private String importe;

    //debe ser alfabetico, longitud maxima de 50
    @NotBlank(message = "El cliente no puede ir vacio")
    @Size(max = 50, message = "La longitud máxima del cliente es de 50 caracteres")
    @Pattern(regexp = "[a-zA-Z]+", message = "El cliente debe contener solo caracteres alfabeticos")
    private String cliente;

    @NotBlank(message = "El codigo sha no puede ir vacio")
    private String sha;
}
