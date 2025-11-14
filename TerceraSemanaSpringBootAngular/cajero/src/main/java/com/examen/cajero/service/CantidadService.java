package com.examen.cajero.service;

import com.examen.cajero.dominio.Cantidad;
import com.examen.cajero.dominio.Denominacion;

import java.util.List;

public interface CantidadService {
    List<Cantidad> listaCantidadesDeDenominaciones();
    Cantidad obtenCantidadPorDenominacion(Denominacion denominacionABuscar);
    Cantidad actualizarCantidad(Cantidad cantidadAActualizar);
    float obtenFondoTotal();
}
