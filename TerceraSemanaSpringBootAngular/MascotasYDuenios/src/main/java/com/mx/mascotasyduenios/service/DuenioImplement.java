package com.mx.mascotasyduenios.service;

import com.mx.mascotasyduenios.dao.IDuenioDao;
import com.mx.mascotasyduenios.dominio.Duenio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DuenioImplement implements IDuenioService{

    @Autowired
    private IDuenioDao duenioDao;

    @Override
    public List<Duenio> listar() {
        return duenioDao.findAll(Sort.by(Sort.Direction.ASC, "nombre"));
    }

    @Override
    public void guardar(Duenio duenio) {
        duenioDao.save(duenio);
    }

    @Override
    public void editar(Duenio duenio) {
        duenioDao.save(duenio);

    }

    @Override
    public Duenio buscar(int idDuenio) {
        return duenioDao.findById(idDuenio).orElse(null);
    }

    @Override
    public void eliminar(int idDuenio) {
        duenioDao.deleteById(idDuenio);
    }
}
