package com.mx.libroprestamo.service;

import com.mx.libroprestamo.dao.ILibroDao;
import com.mx.libroprestamo.dominio.Libro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroImplementacion implements ILibroService{
    @Autowired
    private ILibroDao libroDao;

    @Override
    public List<Libro> listar() {
        return libroDao.findAll(Sort.by(Sort.Direction.ASC, "idLibro"));
    }

    @Override
    public void guardar(Libro libro) {
        libroDao.save(libro);
    }

    @Override
    public void editar(Libro libro) {
        libroDao.save(libro);
    }

    @Override
    public Libro buscar(int idLibro) {
        return libroDao.findById(idLibro).orElse(null);
    }

    @Override
    public void eliminar(int idLibro) {
        libroDao.deleteById(idLibro);
    }

    //validar si existe
    public boolean existeLibro(String nombre){
        return libroDao.existsByNombre(nombre);
    }
}
