package com.mx.mscliente.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "CLIENTE")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//para generar automaticamente el id
    private int idCliente;
    private String nombre;
    private String app;
    private int edad;
    private int tiendaId;
}
