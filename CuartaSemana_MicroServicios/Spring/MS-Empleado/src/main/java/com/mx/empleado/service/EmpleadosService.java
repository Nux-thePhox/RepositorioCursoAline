package com.mx.empleado.service;

import com.mx.empleado.dto.ResponseDto;
import com.mx.empleado.entity.Empleado;
import com.mx.empleado.repository.EmpleadosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import static com.mx.empleado.dto.ResponseConstantes.*;

@Service
public class EmpleadosService {

    @Autowired
    EmpleadosRepository dao;

    public List<Empleado> obtenTodosLosEmpleados(){
        return dao.findAll(Sort.by(Sort.Direction.ASC, "idEmpleado"));
    }

    public ResponseDto guardarEmpleado(Empleado empleadoNuevo){
        ResponseDto respuestaValidacionDatos = existenDatosAlmacenados(empleadoNuevo);
        if(respuestaValidacionDatos.getCodigoRespuesta() == DATOS_DUPLICADOS){
            return respuestaValidacionDatos;
        }else{
            if(empleadoNuevo.getEdad() < 18){
                return new ResponseDto(RESPUESTA_FALLIDA, "El empleado no puede ser menor de edad");
            }
            dao.save(empleadoNuevo);
            return new ResponseDto(RESPUESTA_EXITOSA, "El empleado fue guardado con exito");
        }
    }

    public Empleado buscarEmpleado(int idEmpleado){
        return dao.findById(idEmpleado).orElse(null);
    }

    public void eliminaEmpleado(int idEmpleado){
        dao.deleteById(idEmpleado);
    }

    public ResponseDto editarEmpleado(Empleado empleadoAEditar, Empleado empleadoExiste){
        if(nuevosDatosClaveSonLosMismos(empleadoAEditar, empleadoExiste)){
            dao.save(empleadoAEditar);
            return new ResponseDto(RESPUESTA_EXITOSA, "Empleado editado exitosamente");
        }else{
            ResponseDto existeEmpleado = existenDatosAlmacenados(empleadoAEditar);
            if(existeEmpleado.getCodigoRespuesta() == DATOS_DUPLICADOS){
                return existeEmpleado;
            }
            if(empleadoAEditar.getEdad() < 18){
                return new ResponseDto(RESPUESTA_FALLIDA, "El empleado no puede ser menor de edad");
            }
            dao.save(empleadoAEditar);
            return new ResponseDto(RESPUESTA_EXITOSA, "Empleado editado exitosamente");
        }
    }

    public List<Empleado> listarPorTienda(int tiendaId){
        return dao.findByTiendaId(tiendaId);
    }

    public boolean nuevosDatosClaveSonLosMismos(Empleado nuevo, Empleado anterior){
        return nuevo.getNombre().equals(anterior.getNombre())
                && nuevo.getApp().equals(anterior.getApp())
                && nuevo.getContacto().equals(anterior.getContacto());
    }
    
    private ResponseDto existenDatosAlmacenados(Empleado nuevoEmpleado){
        ResponseDto respuesta= new ResponseDto(RESPUESTA_EXITOSA);
        StringBuilder sb = new StringBuilder();
        boolean existeId = dao.existsById(nuevoEmpleado.getIdEmpleado());
        boolean existeNombreAndApp = dao.existsByNombreAndApp(nuevoEmpleado.getNombre(), nuevoEmpleado.getApp());
        boolean existeContacto = dao.existsByContacto(nuevoEmpleado.getContacto());
        sb.append(existeId ? "Ya existe un empleado con ese id.\n" : "");
        sb.append(existeNombreAndApp ? "El nombre "+nuevoEmpleado.getNombre()+" "+nuevoEmpleado.getApp()
                +" ya fue registrado.\n" : "");
        sb.append(existeContacto ? "El telefono de contacto ya fue registrado. Ingresa otro.\n" : "");
        if(existeId || existeContacto || existeNombreAndApp){
            respuesta.setMensaje(sb.toString());
            respuesta.setCodigoRespuesta(DATOS_DUPLICADOS);
            return respuesta;
        }
        return respuesta;
    }
}
