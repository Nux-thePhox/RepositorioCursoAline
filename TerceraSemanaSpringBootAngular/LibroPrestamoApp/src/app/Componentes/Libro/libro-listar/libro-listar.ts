import { Component, OnInit } from '@angular/core';
import { Libro } from '../../../Entidades/Libro';
import { WS } from '../../../Servicios/ws';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-libro-listar',
  imports: [],
  templateUrl: './libro-listar.html',
  styleUrl: './libro-listar.css',
})
export class LibroListar implements OnInit {
  librito: Libro = new Libro();
  libros !: Libro[];

  constructor(private service: WS, private router: Router) { }

  ngOnInit(): void {
    this.listarLibros();
  }

  listarLibros() {
    this.service.listarLibro().subscribe(data => {
      this.libros = data
    });
  }

  botonEditar(idLibro: number) {
    localStorage.setItem('idLibroAEditar', idLibro.toString());
    this.router.navigate(['editarLibro']);
  }

  botonEliminar(idLibro: number) {
    Swal.fire({
      title: "Quieres eliminar este registro?",
      text: "No se pueden revertir los cambios!",
      icon: "warning",
      showCancelButton: true,
      confirmButtonColor: "#3085d6",
      cancelButtonColor: "#d33",
      confirmButtonText: "Si, eliminar!"
    }).then((result) => {
      if (result.isConfirmed) {
        this.service.eliminarLibro(idLibro).subscribe(data => {
          Swal.fire({
            title: "Eliminado!",
            text: "El registro ha sido eliminado.",
            icon: "success"
          });
        });
        this.listarLibros();
      } else if (result.isDismissed) {
        Swal.fire({
          title: "ELIMINAR",
          text: "ELIMINACION CANCELADA",
          icon: "info",
          confirmButtonText: "OK"
        })
      }
    });
  }
}
