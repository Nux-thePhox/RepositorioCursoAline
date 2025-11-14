import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Prestamo } from '../../../Entidades/Prestamo';
import { WS } from '../../../Servicios/ws';
import { Router } from '@angular/router';
import { Libro } from '../../../Entidades/Libro';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-prestamo-editar',
  imports: [FormsModule],
  templateUrl: './prestamo-editar.html',
  styleUrl: './prestamo-editar.css',
})
export class PrestamoEditar implements OnInit {

  prestamoAEditar: Prestamo = new Prestamo();
  libroAux: Libro = new Libro;

  constructor(private service: WS, private router: Router) { }

  ngOnInit(): void {
    this.buscarPrestamoPorId();
  }

  buscarPrestamoPorId() {
    const idPrestamoABuscarString = localStorage.getItem('idPrestamoAeditar');
    if (idPrestamoABuscarString !== null) {
      const idPrestamoABuscarNumero = parseInt(idPrestamoABuscarString, 10); // El '10' es la base decimal
      if (!isNaN(idPrestamoABuscarNumero)) {
        this.service.buscarPrestamo(idPrestamoABuscarNumero).subscribe(data => {
          this.prestamoAEditar = data;
          if(this.prestamoAEditar.libroId === null){
            this.libroAux = new Libro ();
          }else{
            this.libroAux = this.prestamoAEditar.libroId;
          }
        });
      } else {
        console.log("Valor inexistente en el localStorage");

      }
    } else {
      console.log("Valor inexistente en el localStorage");
    }
  }

  guardarCambiosPrestamo() {
    this.prestamoAEditar.libroId = this.libroAux;
    this.service.editarPrestamo(this.prestamoAEditar).subscribe(data => {
      Swal.fire({
        title: "Deseas guardar los cambios de este prestamo en el registro ?",
        showDenyButton: true,
        confirmButtonText: "Guardar",
        denyButtonText: `No Guardar`
      }).then((result) => {
        /* Read more about isConfirmed, isDenied below */
        if (result.isConfirmed) {
          Swal.fire("Cambios Guardados!", "", "success");
          this.router.navigate(['listarPrestamo']);
        } else if (result.isDenied) {
          Swal.fire("De acuerdo, no los guardo", "", "info");
        }
      });
    });
  }
}
