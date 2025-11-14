import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Celular } from '../../Entidad/Celular';
import { Router } from '@angular/router';
import { Ws } from '../../Servicios/ws';

@Component({
  selector: 'app-listar-por-marca',
  imports: [FormsModule],
  templateUrl: './listar-por-marca.html',
  styleUrl: './listar-por-marca.css',
})
export class ListarPorMarca implements OnInit{
  marca: String = "";

  celulares: Celular[] = []; // lista

  constructor(private router: Router, private service: Ws) { };

  listarCelulares() {
    this.service.listarPorMarcaC().subscribe(data => {
      this.celulares = data;
    });
  }

  botonBuscarMarca(){
    
  }
}
