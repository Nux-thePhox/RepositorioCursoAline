import { Component, signal } from '@angular/core';
import { Router, RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('CajeroApp');

  constructor(private router: Router){};

  mostrarFondos(){
    this.router.navigate(['consultaEfectivoDisp']);
  }

  retirarEfectivo(){
    this.router.navigate(['retirarEfectivo']);
  }
}
