package com.mx.tienda.client;

import com.mx.tienda.dto.EmpleadoDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "MS-Empleado", url = "http://localhost:8012/Empleados")
public interface IEmpleadoFeignConfig {

    @GetMapping("/listarPorTienda/{tiendaId}")
    List<EmpleadoDto> listarPorTienda(@PathVariable int tiendaId);

}
