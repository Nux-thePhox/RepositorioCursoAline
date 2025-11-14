package com.mx.producto.service;

import com.mx.producto.entity.Producto;
import com.mx.producto.repository.ProductoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepo dao;

    public void guardar(Producto producto){
        dao.save(producto);
    }

    public void editar(Producto producto){
        dao.save(producto);
    }

    public Producto buscar(int idProducto){
        return dao.findById(idProducto).orElse(null);
    }

    public void eliminar(int idProducto){
        dao.deleteById(idProducto);
    }

    public List<Producto> listar(){
        return dao.findAll(Sort.by(Sort.Direction.ASC, "idProducto"));
    }

    public List<Producto> listarPorTienda(int tiendaId){
        return dao.findByTiendaId(tiendaId);
    }
}
