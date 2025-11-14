package com.examen.cajero.service.impl;

import com.examen.cajero.dao.ITipoMonedaDao;
import com.examen.cajero.dominio.TipoMoneda;
import com.examen.cajero.service.TipoMonedaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoMonedaImpl implements TipoMonedaService {

    @Autowired
    ITipoMonedaDao tipoMonedaDao;

    @Override
    public List<TipoMoneda> listarLasMonedas() {
        return tipoMonedaDao.findAll();
    }
}
