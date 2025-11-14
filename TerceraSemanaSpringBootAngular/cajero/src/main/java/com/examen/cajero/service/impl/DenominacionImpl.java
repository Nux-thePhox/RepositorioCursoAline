package com.examen.cajero.service.impl;

import com.examen.cajero.dao.IDenominacionDao;
import com.examen.cajero.dominio.Denominacion;
import com.examen.cajero.service.DenominacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DenominacionImpl implements DenominacionService {

    @Autowired
    IDenominacionDao denominacionDao;

    @Override
    public List<Denominacion> listarDenominaciones() {
        return denominacionDao.findAll(Sort.by(Sort.Direction.DESC, "valor"));
    }

    @Override
    public Denominacion obtenDenominacionPorId(int idDenominacion) {
        return denominacionDao.findById(idDenominacion).orElse(null);
    }

    public Denominacion obtenDenominacionPorValor(float valor){
        return denominacionDao.findByValor(valor);
    }
}
