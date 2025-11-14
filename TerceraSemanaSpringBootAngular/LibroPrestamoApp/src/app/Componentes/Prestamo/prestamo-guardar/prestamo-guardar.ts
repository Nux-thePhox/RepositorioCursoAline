import { Component } from '@angular/core';
import { Prestamo } from '../../../Entidades/Prestamo';
import { WS } from '../../../Servicios/ws';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';
import Swal from 'sweetalert2';
import { Libro } from '../../../Entidades/Libro';

@Component({
  selector: 'app-prestamo-guardar',
  imports: [FormsModule],
  templateUrl: './prestamo-guardar.html',
  styleUrl: './prestamo-guardar.css',
})
export class PrestamoGuardar {
  prestamoAGuardar: Prestamo = new Prestamo;
  libroAux : Libro = new Libro;

  constructor(private service: WS, private router: Router) { }

  guardarPrestamo() {
    this.prestamoAGuardar.libroId = this.libroAux;
    this.service.guardarPrestamo(this.prestamoAGuardar).subscribe(data => {
      Swal.fire({
        title: "Deseas agregar este prestamo al registro ?",
        showDenyButton: true,
        confirmButtonText: "Guardar Prestamo",
        denyButtonText: `Don't save`
      }).then((result) => {
        /* Read more about isConfirmed, isDenied below */
        if (result.isConfirmed) {
          Swal.fire("Prestamo Guardado!", "", "success");
          this.router.navigate(['listarPrestamo']);
        } else if (result.isDenied) {
          Swal.fire("De acuerdo, no lo guardo", "", "info");
        }
      });
    })
  }
}
