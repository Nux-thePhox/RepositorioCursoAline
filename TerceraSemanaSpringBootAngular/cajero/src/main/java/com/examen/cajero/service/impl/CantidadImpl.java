package com.examen.cajero.service.impl;

import com.examen.cajero.dao.ICantidadDao;
import com.examen.cajero.dominio.Cantidad;
import com.examen.cajero.dominio.Denominacion;
import com.examen.cajero.service.CantidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CantidadImpl implements CantidadService {

    @Autowired
    ICantidadDao cantidadDao;

    //Devuelve la cantidad por denominación manejada en el cajero
    @Override
    public List<Cantidad> listaCantidadesDeDenominaciones() {
        return cantidadDao.findAll();
    }

    @Override
    public Cantidad obtenCantidadPorDenominacion(Denominacion denominacionABuscar) {
        return cantidadDao.findByDenominacionId(denominacionABuscar);
    }

    @Override
    public Cantidad actualizarCantidad(Cantidad cantidadAActualizar) {
        return cantidadDao.save(cantidadAActualizar);
    }

    @Override
    public float obtenFondoTotal() {
        return  cantidadDao.obtenFondoTotal();
    }
}
