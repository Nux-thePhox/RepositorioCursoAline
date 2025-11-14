import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { WS } from '../../Servicios/ws';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-retiro-efectivo',
  imports: [CommonModule, FormsModule],
  templateUrl: './retiro-efectivo.html',
  styleUrl: './retiro-efectivo.css',
})
export class RetiroEfectivo {
  montoARetirar: number | undefined;
  montoInvalido: boolean  = false;

  constructor(private router: Router, private service: WS) { };

  retiroEfectivoSugerido(retiro: number) {
    localStorage.setItem('cantidadAEntregar', retiro.toString());
    this.router.navigate(['entregaEfectivo']);
    console.log('Se retirara ', retiro);
  }

  otroRetiroEfectivo() {
    this.montoInvalido = false;
    if (this.montoARetirar && this.montoARetirar > 0) {
      localStorage.setItem('cantidadAEntregar', this.montoARetirar.toString());
      this.router.navigate(['entregaEfectivo']);
      console.log('Se retirara ', this.montoARetirar);
    }else{
      this.montoInvalido = true;
    }

  }
}
