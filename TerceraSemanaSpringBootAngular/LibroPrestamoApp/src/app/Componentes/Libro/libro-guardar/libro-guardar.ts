import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Libro } from '../../../Entidades/Libro';
import { WS } from '../../../Servicios/ws';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-libro-guardar',
  imports: [FormsModule],
  templateUrl: './libro-guardar.html',
  styleUrl: './libro-guardar.css',
})
export class LibroGuardar {
  libritoAGuardar: Libro = new Libro();

  constructor(private service: WS, private router: Router) { }

  guardandoLibro() {
    this.service.guardarLibro(this.libritoAGuardar).subscribe(data => {
      Swal.fire({
        title: "Deseas agregar este libro al registro ?",
        showDenyButton: true,
        confirmButtonText: "Save",
        denyButtonText: `Don't save`
      }).then((result) => {
        /* Read more about isConfirmed, isDenied below */
        if (result.isConfirmed) {
          Swal.fire("Libro Guardado!", "", "success");
          this.router.navigate(['listarLibro']);
        } else if (result.isDenied) {
          Swal.fire("De acuerdo, no lo guardo", "", "info");
        }
      });
    });
  }
}
