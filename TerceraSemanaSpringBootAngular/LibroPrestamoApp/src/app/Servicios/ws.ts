import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Libro } from '../Entidades/Libro';
import { Prestamo } from '../Entidades/Prestamo';

@Injectable({
  providedIn: 'root',
})
export class WS {
  constructor(private http : HttpClient){}

  url = "http://localhost:8003"

  listarLibro(){
    return this.http.get<Libro[]>(this.url + "/libro/listar");
  }

  listarPrestamos(){
    return this.http.get<Prestamo[]>(this.url + "/prestamos");
  }

  guardarLibro(libro : Libro){
    return this.http.post<String>(this.url + "/libro/guardar", libro, {responseType : "text" as "json"});
  }

  guardarPrestamo(prestamo : Prestamo){
    return this.http.post<String>(this.url + "/prestamos/guardarprestamo", prestamo, {responseType : "text" as "json"});
  }

  buscarLibro(idLibroAEditar : number){
    return this.http.get<Libro>(this.url + "/libro/buscar/"+idLibroAEditar);
  }

  buscarPrestamo(idPrestamoABuscar : number){
    return this.http.get<Prestamo>(this.url + "/prestamos/"+idPrestamoABuscar);
  }

  editarLibro(libro : Libro){
    return this.http.post<String>(this.url+"/libro/editar", libro, {responseType : "text" as "json"});
  }

  editarPrestamo(prestamo: Prestamo){
    return this.http.put<String>(this.url+"/prestamos",prestamo, {responseType: "text" as "json"});
  }

  eliminarLibro(idLibroAEliminar : number){
    return this.http.delete<String>(this.url+"/libro/eliminar/"+idLibroAEliminar, {responseType : "text" as "json"});
  }

  eliminarPrestamo(idLibroAEliminar: number){
    return this.http.delete<String>(this.url+"/prestamos/"+idLibroAEliminar, {responseType : "text" as "json"});
  }
}
