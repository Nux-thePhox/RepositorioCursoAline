package com.mx.Celular.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.mx.Celular.Dominio.Celular;
import com.mx.Celular.Service.CelularServiceImp;

@RestController //configura mi clase para usar el protocolo http recibir solictudes y retornar respuestas
@RequestMapping(path = "api/Cel") //todo mis controladores llevaran este path
@CrossOrigin //todas las rutas tienen acceso a mi clase controlador
public class CelularController {
	
	@Autowired
	private CelularServiceImp service;
	
	/*ruta para hacer peticiones a mi controlador
	 * protocolo://host:puerto/path
	 * 
	 * http://localhost:8001/api/Cel
	 * */
	//listar -> http://localhost:8001/api/Cel/listar
	@GetMapping(path = "listar")
	public List<Celular> listar(){
		return service.mostrar();
	}
	//guardar --> http://localhost:8001/api/Cel/guardar
	@PostMapping(path = "guardar")
	public void guardar(@RequestBody Celular celular) {
		service.guardar(celular);
	}
	
	//editar --> http://localhost:8001/api/Cel/editar
	@PutMapping(path = "editar")
	public void editar(@RequestBody Celular celular) {
		service.editar(celular);
	}
	
	//eliminar --> http://localhost:8001/api/Cel/eliminar
	@DeleteMapping(path = "eliminar")
	public void eliminar(@RequestBody Celular celular) {
		service.eliminar(celular);
	}
	
	//buscar --> http://localhost:8001/api/Cel/buscar
	@PostMapping(path="buscar")
	public Celular buscar(@RequestBody Celular celular) {
		return service.buscar(celular);
	}
	
	//metodo que aplica descuento
    @PostMapping("/descuento")
    public ResponseEntity<String> aplicarDescuento(@RequestParam Integer pDescuento){
        service.aplicarDescuento(pDescuento);
        return ResponseEntity.ok("El Descuento del "+pDescuento+"% se aplico correctamente");
    }

    @GetMapping("/celular/marca")
    public ResponseEntity<?> obtenCelularesPorMarca(@RequestParam String marca){
        List<Celular> celulares = service.getCelularesByMarca(marca);
        if(celulares.isEmpty()){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.ok(celulares);
    }

}
