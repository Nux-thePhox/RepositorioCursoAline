package com.mx.mscliente.service;

import com.mx.mscliente.entity.Cliente;

public interface ICliente {
    void save(Cliente cliente);
    void update(Cliente cliente);
    void delete(int idCliente);
    Cliente findCliente(int idCliente);
}
