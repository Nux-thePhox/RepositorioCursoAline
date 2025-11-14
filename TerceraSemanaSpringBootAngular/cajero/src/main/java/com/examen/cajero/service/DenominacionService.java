package com.examen.cajero.service;

import com.examen.cajero.dominio.Denominacion;

import java.util.List;

public interface DenominacionService {
    List<Denominacion> listarDenominaciones();
    Denominacion obtenDenominacionPorId(int idDenominacion);
    Denominacion obtenDenominacionPorValor(float valor);
}
