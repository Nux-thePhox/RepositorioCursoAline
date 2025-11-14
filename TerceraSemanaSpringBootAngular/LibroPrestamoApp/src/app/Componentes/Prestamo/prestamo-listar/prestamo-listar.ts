import { Component, OnInit } from '@angular/core';
import { Prestamo } from '../../../Entidades/Prestamo';
import { WS } from '../../../Servicios/ws';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-prestamo-listar',
  imports: [],
  templateUrl: './prestamo-listar.html',
  styleUrl: './prestamo-listar.css',
})
export class PrestamoListar implements OnInit {
  prestamoAMostrar: Prestamo = new Prestamo();
  listaPrestamos !: Prestamo[];

  constructor(private service: WS, private router: Router) { }

  ngOnInit(): void {
    this.listarPrestamos();
  }

  listarPrestamos() {
    this.service.listarPrestamos().subscribe(data => {
      this.listaPrestamos = data
    });
  }

  botonEditar(idPrestamo: number) {
    localStorage.setItem('idPrestamoAeditar', idPrestamo.toString());
    this.router.navigate(['editarPrestamo']);
  }

  botonEliminar(idPrestamo: number) {
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
        this.service.eliminarPrestamo(idPrestamo).subscribe(data => {
          Swal.fire({
            title: "Eliminado!",
            text: "El registro ha sido eliminado.",
            icon: "success"
          });
          this.listarPrestamos();
        });
      } else if (result.isDismissed) {
        Swal.fire({
          title: "ELIMINAR",
          text: "ELIMINACION CANCELADA",
          icon: "info",
          confirmButtonText: "OK"
        });
      }
    });
  }
}
