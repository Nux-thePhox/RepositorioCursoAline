import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { WS } from '../../Servicios/ws';

@Component({
  selector: 'app-consulta-liquidez',
  imports: [],
  templateUrl: './consulta-liquidez.html',
  styleUrl: './consulta-liquidez.css',
})
export class ConsultaLiquidez implements OnInit{

  efectivoTotal: number | undefined;
  mensajeError: String | undefined;
  isLoading: boolean = true; //Para mostrar un mensaje de carga

  constructor(private router: Router, private service: WS){};

  ngOnInit(): void {
    this.obtenEfectivoDisp();
  }

  obtenEfectivoDisp(){
    //Se limpian los contenidos de las variables
    this.isLoading = true;
    this.mensajeError = undefined;

    this.service.mostrarFondosDisponibles().subscribe({
      next: (data) => {
        this.efectivoTotal = data;
        this.isLoading = false;
      },
      error: (error) => {
        this.mensajeError = 'Tenemos inconvenientes en el Sistema, Vuelve más tarde';
        this.isLoading = false;
        console.log("Incidencia al consumir servicio: ", error);
      }
    });
  }

  mostrarFondos(){
    this.router.navigate(['consultaEfectivoDisp']);
  }
}
