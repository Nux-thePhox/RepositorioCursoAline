import { Component, OnInit } from '@angular/core';
import { Cantidad } from '../../Entidades/Cantidad';
import { Router } from '@angular/router';
import { WS } from '../../Servicios/ws';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-entregar-efectivo',
  imports: [],
  templateUrl: './entregar-efectivo.html',
  styleUrl: './entregar-efectivo.css',
})
export class EntregarEfectivo implements OnInit {

  cantidadAEntregar: Cantidad[] | undefined;
  mensajeError: String | undefined;
  isLoading: boolean = false;
  efectivoEntregado : number | undefined;
  constructor(private router : Router, private service : WS){};

  ngOnInit(): void {
    this.entregarCantidad();
  }

  entregarCantidad() {
    this.isLoading = false;
    this.mensajeError = undefined;
    this.efectivoEntregado = undefined;
    this.cantidadAEntregar = undefined;
    const monto = localStorage.getItem('cantidadAEntregar');
    if (monto !== null) {
      this.isLoading = true;
      const montoAretirar = parseInt(monto, 10); // El '10' es la base decimal
      if (!isNaN(montoAretirar)) {
        this.service.realizaRetiroEfectivo(montoAretirar).subscribe({
          next: (data) => {
            this.isLoading = false;
            this.cantidadAEntregar = data;
            this.efectivoEntregado = montoAretirar;
          },
          error: (error: HttpErrorResponse) => {
            this.isLoading = false;
            if (error.status === 402) {
              // El backend envió un mensaje de error en el cuerpo
              this.mensajeError = error.error;// El cuerpo de la respuesta es el mensaje de error
            } else {
              //Otros errores,
              this.mensajeError = 'Tenemos problemas con el sistema. Intentalo de nuevo más tarde. ';
              console.log('Back: ',error);
            }
          }
        });
      } else {
        this.isLoading = false;
        this.mensajeError = "Tenemos un problema al recibir tu monto a retirar, intenta de nuevo más tarde";
        console.log("Valor inexistente en el localStorage");
      }
    } else {
      this.isLoading = false;
      this.mensajeError = "Tenemos un problema al recibir tu monto a retirar, intenta de nuevo más tarde";
      console.log("Valor inexistente en el localStorage");
    }
  }

}
