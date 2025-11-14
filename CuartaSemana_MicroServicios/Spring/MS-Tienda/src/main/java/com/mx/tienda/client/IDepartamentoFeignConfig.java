package com.mx.tienda.client;

import com.mx.tienda.dto.DepartamentoDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/*Determina como seremos clientes http, colicita el nombre, url */
@FeignClient(name = "MS-Departamentos", url = "http://localhost:8013/Departamentos")
public interface IDepartamentoFeignConfig {

    @GetMapping("porTiendas/{tiendaId}")
    List<DepartamentoDto> buscarPorTienda(@PathVariable int tiendaId);
}
