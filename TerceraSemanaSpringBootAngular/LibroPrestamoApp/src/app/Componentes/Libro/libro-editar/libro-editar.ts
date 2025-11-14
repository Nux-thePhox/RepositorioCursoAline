import { Component, OnInit } from '@angular/core';
import { Libro } from '../../../Entidades/Libro';
import { WS } from '../../../Servicios/ws';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-libro-editar',
  imports: [FormsModule],
  templateUrl: './libro-editar.html',
  styleUrl: './libro-editar.css',
})
export class LibroEditar implements OnInit{
  libroAEditar: Libro = new Libro();

  constructor(private service: WS, private router: Router) { }

  ngOnInit(): void {
    this.buscarLibroPorId();
  }

  buscarLibroPorId() {
    const idLibroABuscarString = localStorage.getItem('idLibroAEditar');
    if (idLibroABuscarString !== null) {
      const idLibroABuscarNumero = parseInt(idLibroABuscarString, 10); // El '10' es la base decimal
      if (!isNaN(idLibroABuscarNumero)) {
        this.service.buscarLibro(idLibroABuscarNumero).subscribe(data => {
          this.libroAEditar = data;
        });
      } else {
        console.log("Valor inexistente en el localStorage");

      }
    } else {
      console.log("Valor inexistente en el localStorage");
    }
  }

  botonGuardarCambios(){
    this.service.editarLibro(this.libroAEditar).subscribe(data => {
      Swal.fire({
              title: "Deseas guardar los cambios de este libro en ell registro ?",
              showDenyButton: true,
              confirmButtonText: "Guardar",
              denyButtonText: `No Guardar`
            }).then((result) => {
              /* Read more about isConfirmed, isDenied below */
              if (result.isConfirmed) {
                Swal.fire("Cambios Guardados!", "", "success");
                this.router.navigate(['listarLibro']);
              } else if (result.isDenied) {
                Swal.fire("De acuerdo, no los guardo", "", "info");
              }
            });
    });
  }
}
