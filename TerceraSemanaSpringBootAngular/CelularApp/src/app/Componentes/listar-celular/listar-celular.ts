import { Component, OnInit } from '@angular/core';
import { Celular } from '../../Entidad/Celular';
import { Router } from '@angular/router';
import { Ws } from '../../Servicios/ws';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-listar-celular',
  imports: [],
  templateUrl: './listar-celular.html',
  styleUrl: './listar-celular.css',
})

//Ciclo de vida, una vez que accedamos al componente la informacion que solicitemos se debe de cargar en automatico.
//al inicio de la carga del componente
export class ListarCelular implements OnInit {
  //instanciar la entidad
  celular: Celular = new Celular;

  celulares: Celular[] = []; // lista

  constructor(private router: Router, private service: Ws) { };

  //Metodo pedido por la interfaz
  ngOnInit(): void {
    this.listarCelulares();
  }

  listarCelulares() {
    this.service.listarCelu().subscribe(data => {
      this.celulares = data;
    });
  }

  //UN METODO PAR REDIRECCIONAR AL COMPONENTE DE EDITAR
  editarButtom(celular: Celular) {
    //almacenamos temporalmente los datos del cel, para poder obtener informacion
    localStorage.setItem('id', celular.idCelular.toString());
    this.router.navigate(['editarC'])
  }

  btnEliminar(c: Celular) {
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
        this.service.eliminarC(c).subscribe(data => {

        })
        Swal.fire({
          title: "Eliminado!",
          text: "El registro ha sido eliminado.",
          icon: "success"
        });
        this.listarCelulares();
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
