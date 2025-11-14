package com.mx.empleado.controller;

import com.mx.empleado.dto.ResponseDto;
import com.mx.empleado.entity.Empleado;
import com.mx.empleado.service.EmpleadosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.mx.empleado.dto.ResponseConstantes.*;

//No se ocupa CrossOrigin porque  CorsFilter
//@CrossOrigin
@RestController
@RequestMapping("/Empleados")
public class EmpleadoController {

    @Autowired
    private EmpleadosService service;

    @GetMapping
    public ResponseEntity<?> listarEmpleados(){
        List<Empleado> listaEmpleados = service.obtenTodosLosEmpleados();
        if(listaEmpleados.isEmpty()){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.ok(listaEmpleados);
    }

    @PostMapping
    public ResponseEntity<?> guardarEmpleado(@RequestBody Empleado empleado){
        String msjError = validaNombreIngresados(empleado);
        if(!msjError.isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(msjError);
        }
        msjError = validaTelefonoContacto(empleado.getContacto());
        if(!msjError.isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(msjError);
        }
        ResponseDto respuestaGuardado = service.guardarEmpleado(empleado);
        if(respuestaGuardado.getCodigoRespuesta() == DATOS_DUPLICADOS){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(respuestaGuardado.getMensaje());
        }
        if(respuestaGuardado.getCodigoRespuesta() == RESPUESTA_FALLIDA){
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(respuestaGuardado.getMensaje());
        }
        return ResponseEntity.ok(respuestaGuardado.getMensaje());
    }

    @GetMapping("/{idEmpleado}")
    public ResponseEntity<?> buscarEmpleado(@PathVariable int idEmpleado){
        Empleado empleadoBuscado = service.buscarEmpleado(idEmpleado);
        if(empleadoBuscado == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El id buscado no existe");
        }else{
            return ResponseEntity.ok(empleadoBuscado);
        }
    }

    @DeleteMapping("/{idEmpleado}")
    public ResponseEntity<?> eliminarEmpleado(@PathVariable int idEmpleado){
        Empleado empleadoBuscado = service.buscarEmpleado(idEmpleado);
        if(empleadoBuscado == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El empleado que deseas eliminar no existe");
        }else{
            return ResponseEntity.ok(empleadoBuscado);
        }
    }

    @PutMapping
    public ResponseEntity<?> editarEmpleado(@RequestBody Empleado empleado){
        Empleado empleadoBuscado = service.buscarEmpleado(empleado.getIdEmpleado());
        if(empleadoBuscado == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El id buscado no existe");
        }else{
            String msjError = validaNombreIngresados(empleado);
            if(!msjError.isEmpty()){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(msjError);
            }
            msjError = validaTelefonoContacto(empleado.getContacto());
            if(!msjError.isEmpty()){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(msjError);
            }

            ResponseDto respuestaEditado = service.editarEmpleado(empleado, empleadoBuscado);
            if(respuestaEditado.getCodigoRespuesta() == DATOS_DUPLICADOS){
                return ResponseEntity.status(HttpStatus.CONFLICT).body(respuestaEditado.getMensaje());
            }
            if(respuestaEditado.getCodigoRespuesta() == RESPUESTA_FALLIDA){
                return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(respuestaEditado.getMensaje());
            }
            return ResponseEntity.ok(respuestaEditado.getMensaje());
        }
    }

    @GetMapping("/listarPorTienda/{tiendaId}")
    public ResponseEntity<?> listarPorTienda(@PathVariable int tiendaId){
        List<Empleado> listaEmpleados = service.listarPorTienda(tiendaId);
        if(listaEmpleados.isEmpty()){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.ok(listaEmpleados);
    }

    private String validaNombreIngresados(Empleado empleadoIngresado){
        StringBuilder sb = new StringBuilder();
        boolean nombreVacio = empleadoIngresado.getNombre().isEmpty();
        boolean appVacio = empleadoIngresado.getApp().isEmpty();
        boolean contactoVacio = empleadoIngresado.getContacto().isEmpty();
        sb.append(nombreVacio ? "Falta que ingreses un nombre.\n" : "");
        sb.append(appVacio ? "Falta que ingreses un apellido.\n" : "");
        sb.append(contactoVacio ? "Falta que ingreses un telefono de contacto.\n" : "");
        return sb.toString();
    }

    private String validaTelefonoContacto(String contacto){
        if(contacto.length() != 10){
            return "El número de telefono debe de tener 10 digitos";
        }
        for (char c : contacto.toCharArray()) {
            if (!Character.isDigit(c)) {
                return "El contacto debe ser numerico";
            }
        }
        return "";
    }

}
