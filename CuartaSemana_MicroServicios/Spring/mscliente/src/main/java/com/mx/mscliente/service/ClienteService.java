package com.mx.mscliente.service;

import com.mx.mscliente.entity.Cliente;
import com.mx.mscliente.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService implements ICliente{

    @Autowired
    private ClienteRepository dao;


    @Override
    public void save(Cliente cliente) {
        dao.save(cliente);
    }

    @Override
    public void update(Cliente cliente) {
        dao.save(cliente);
    }

    @Override
    public void delete(int idCliente) {
        dao.deleteById(idCliente);
    }

    @Override
    public Cliente findCliente(int idCliente) {
        return dao.findById(idCliente).orElse(null);
    }


    public boolean existsCliente(String nombre, String app){
        return dao.existsByNombreAndAppAllIgnoringCase(nombre, app);
    }

    public List<Cliente> findByTienda(int tiendaId){
        return dao.findByTiendaId(tiendaId);
    }

    public List<Cliente> listAllClientes(){
        return dao.findAll(Sort.by(Sort.Direction.ASC, "nombre"));
    }

    public boolean nuevoNombreEsElMismo(Cliente nuevo, Cliente anterior){
        return nuevo.getNombre().equals(anterior.getNombre()) && nuevo.getApp().equals(anterior.getApp());
    }
}
