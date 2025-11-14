import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Celular } from '../../Entidad/Celular';
import { Ws } from '../../Servicios/ws';
import Swal from 'sweetalert2';
import { Router } from '@angular/router';

@Component({
  selector: 'app-guardar-celular',
  imports: [FormsModule],
  templateUrl: './guardar-celular.html',
  styleUrl: './guardar-celular.css',
})
export class GuardarCelular {
  cel : Celular = new Celular();

  constructor(private service: Ws, private router: Router){}
  guardar(){
    this.service.guardarCelu(this.cel).subscribe(data => {
      Swal.fire({
        icon: "success",
        title: "Guardar",
        text: "Tu celular fue guardado con exito",
        showConfirmButton: false,
        timer: 1500
      });
      //una vez guarde, regresa al componente de listar
      this.router.navigate(['listarC'])
    })
  }
}
