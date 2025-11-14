import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Ws } from '../../Servicios/ws';
import { Router } from '@angular/router';
import { Celular } from '../../Entidad/Celular';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-editar-celular',
  imports: [FormsModule],
  templateUrl: './editar-celular.html',
  styleUrl: './editar-celular.css',
})
export class EditarCelular implements OnInit {
  constructor(private service: Ws, private router : Router){}

  cel : Celular = new Celular();

  ngOnInit(): void {
    this.buscarCel();
  }

  buscarCel(){
    let id = localStorage.getItem('id');
    this.cel.idCelular = Number(id);

    this.service.buscarCelu(this.cel).subscribe(data => {
      this.cel = data;
    })
  }

  editarC(){
    this.service.editarCelu(this.cel).subscribe(data => {
      Swal.fire({
              icon: "success",
              title: "Guardar",
              text: "Tu celular fue guardado con exito",
              showConfirmButton: false,
              timer: 1500
            })
    });
    this.router.navigate(['listarC']); //se redirecciona
  }
}
