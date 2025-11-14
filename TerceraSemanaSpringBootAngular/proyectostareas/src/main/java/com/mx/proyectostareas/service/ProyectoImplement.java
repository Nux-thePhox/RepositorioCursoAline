package com.mx.proyectostareas.service;

import com.mx.proyectostareas.dao.IProyectoDao;
import com.mx.proyectostareas.dominio.Proyecto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProyectoImplement implements ProyectosService{

    @Autowired
    private IProyectoDao proyectoDao;

    @Override
    public List<Proyecto> listar() {
        return proyectoDao.findAll(Sort.by(Sort.Direction.ASC, "idProyecto"));
    }

    @Override
    public void guardar(Proyecto proyecto) {
        proyectoDao.save(proyecto);
    }

    @Override
    public void editar(Proyecto proyecto) {
        proyectoDao.save(proyecto);
    }

    @Override
    public Proyecto buscarPorId(int idProyecto) {
        return proyectoDao.findById(idProyecto).orElse(null);
    }

    @Override
    public void eliminarPorId(int idProyecto) {
        proyectoDao.deleteById(idProyecto);
    }

    public boolean existeNombreProyecto(String nombre) {
        return proyectoDao.existsByNombre(nombre);
    }

    public List<Proyecto> findProyectosVencidos(){
        return proyectoDao.findProyectosVencidos();
    }

    public List<Proyecto> findProyectosByNombre(String nombre){
        return proyectoDao.findProyectosByNombre(nombre);
    }
}
