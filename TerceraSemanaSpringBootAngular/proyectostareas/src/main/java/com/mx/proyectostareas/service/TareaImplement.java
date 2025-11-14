package com.mx.proyectostareas.service;

import com.mx.proyectostareas.dao.ITareaDao;
import com.mx.proyectostareas.dominio.Tarea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TareaImplement implements TareasService{

    @Autowired
    private ITareaDao tareaDao;

    @Override
    public List<Tarea> listar() {
        return tareaDao.findAll();
    }

    @Override
    public void guardar(Tarea tarea) {
        tareaDao.save(tarea);
    }

    @Override
    public void editar(Tarea tarea) {
        tareaDao.save(tarea);
    }

    @Override
    public Tarea buscarPorId(int idTarea) {
        return tareaDao.findById(idTarea).orElse(null);
    }

    @Override
    public void eliminarPorId(int idTarea) {
        tareaDao.deleteById(idTarea);
    }

    public boolean existeTituloTarea(String titulo) {
        return tareaDao.existsByTitulo(titulo);
    }

    public List<Tarea> listarTareasVencidas(){
        return tareaDao.findTareassVencidos();
    }
}
