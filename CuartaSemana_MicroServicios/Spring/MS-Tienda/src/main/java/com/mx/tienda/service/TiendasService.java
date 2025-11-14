package com.mx.tienda.service;

import com.mx.tienda.client.IDepartamentoFeignConfig;
import com.mx.tienda.client.IEmpleadoFeignConfig;
import com.mx.tienda.dto.ClienteDto;
import com.mx.tienda.dto.DepartamentoDto;
import com.mx.tienda.dto.EmpleadoDto;
import com.mx.tienda.dto.ProductoDto;
import com.mx.tienda.entity.Tienda;
import com.mx.tienda.repository.TiendasRepository;
import feign.FeignException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class TiendasService {

    @Autowired
    private TiendasRepository dao;

    @Autowired
    private IDepartamentoFeignConfig depFC;

    @Autowired
    private IEmpleadoFeignConfig empleadoFC;

    public void guardar(Tienda tienda){
        dao.save(tienda);
    }

    public void editar(Tienda tienda){
        dao.save(tienda);
    }

    public void eliminar(int idTienda){
        dao.deleteById(idTienda);
    }

    public Tienda buscar(int idTienda){
        return dao.findById(idTienda).orElse(null);
    }

    public List<Tienda> listar(){
        return dao.findAll(Sort.by(Sort.Direction.ASC, "nombre"));
    }

    /*Inyectar el bean de RestTemplate para poder hacer las peticiones HTTP a otros MS*/
    @Autowired
    private RestTemplate restTemplate;

    /*Declaracion del metodo, para visualizar los clientes que pertenecen a la tienda*/
    public List<ClienteDto> listarClientes(int tiendaId){
        List<ClienteDto> clientes = restTemplate.getForObject(
                "http://localhost:8010/Clientes/buscarPorTienda/"+tiendaId, List.class);
        return clientes;
    }

    public List<DepartamentoDto> listarDepas(int tiendaId){
        return depFC.buscarPorTienda(tiendaId);
    }

    public List<EmpleadoDto> listarEmpleados(int tiendaId){
        return empleadoFC.listarPorTienda(tiendaId);
    }

    public List<ProductoDto> listarProductos(int tiendaId){
        List<ProductoDto> productos = restTemplate.getForObject(
                "http://localhost:8011/Productos/listarPorTienda/"+tiendaId, List.class
        );
        return productos;
    }

    //metodo que nos permita listar todo lo que pertenezca a la tienda
    public Map<String, Object> listarTodo(int tiendaId){
        Map<String, Object> resultado = new HashMap<>();

        Tienda tiendita = dao.findById(tiendaId).orElse(null);

        if(tiendita == null) {
            resultado.put("Tienda mensaje: ", "No existe esta tienda");
        }else {
            resultado.put("Informacion de la tienda", tiendita);
            //informacion de Clientes(validacion, existe o no existe)
            try { //un bloque tryCatch para manejar cuando el servicio este apagado
                List<ClienteDto> clientes = listarClientes(tiendaId);
                if(clientes.isEmpty()) {
                    resultado.put("Clientes mensaje: ", "No existen clientes registrado en la tienda");
                }else {
                    resultado.put("Clientes asociados: ", clientes);
                }
            }catch(ResourceAccessException e) {
                resultado.put("Clientes Conexion Error", "El servicio de Clientes no esta disponible");
            }

            try {//un bloque tryCatch para manejar cuando el servicio este apagado
                //informacion de los departamentos(validacion existe o no existe)
                List<DepartamentoDto> departamentos = listarDepas(tiendaId);
                if(departamentos.isEmpty()) {
                    resultado.put("Departamentos mensaje", "No existe informacion de los departamentos");
                }else {
                    resultado.put("Departamentos registrados", departamentos);
                }
            }catch(FeignException e) {
                resultado.put("Departamentos Conexion Error", "El servicio de Departamento no esta disponible ");
            }


            try {
                List<ProductoDto> productos = listarProductos(tiendaId);
                if(productos.isEmpty()) {
                    resultado.put("Productos mensaje: ", "No existen productos registrados en la tienda");
                }else {
                    resultado.put("Productos asociados: ", productos);
                }
            }catch(RestClientException e) {
                resultado.put("Productos Conexion Error", "El servicio de Productos no esta disponible");
            }

            try{
                List<EmpleadoDto> empleados = listarEmpleados(tiendaId);
                if(empleados.isEmpty()) {
                    resultado.put("Empleados mensaje", "No existe informacion de los empleados");
                }else {
                    resultado.put("Empleados registrados", empleados);
                }
            }catch (FeignException e){
                resultado.put("Empleados MS Conexión Error", "El ms de Empleados no responde");
            }
        }


        return resultado;
    }

}
