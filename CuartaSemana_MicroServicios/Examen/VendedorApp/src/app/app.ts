import { Component, signal } from '@angular/core';
import { Router, RouterOutlet } from '@angular/router';
import { WS } from './servicios/ws';
import { Peticion } from './entidades/Peticion';
import { Respuesta } from './entidades/Respuesta';
import { FormBuilder, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { HttpErrorResponse, HttpRequest } from '@angular/common/http';


@Component({
  selector: 'app-root',
  imports: [RouterOutlet, ReactiveFormsModule],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('VendedorApp');
  //variable que almacenara los datos del formulario
  formularioPeticion !: FormGroup;

  //Entidades para la peticion del WS
  peticion: Peticion | undefined;
  respuesta: Respuesta | undefined;

  //Variables para alerts
  transaccionExitosa: boolean = false;
  mensajeError: String | undefined;
  isLoading: boolean = false;

  constructor(private router: Router, private service: WS, private formb: FormBuilder) {// <-- Inyectar FormBuilder
    // Define el FormGroup. Los nombres de las propiedades deben coincidir con 'formControlName' en el HTML.
    this.formularioPeticion = this.formb.group({
      cliente: [''],
      // El campo 'importe' tiene un valor inicial. El 'checked' en el HTML establecerá el valor predeterminado si no se especifica aquí.
      importe: ['']
    });
  };


  enviarPeticion() {
    //Para ocultar los alerts
    this.mensajeError = undefined;
    this.isLoading = false;
    this.transaccionExitosa = false;

    // El valor completo del formulario está aquí:
    const datosDelFormulario = this.formularioPeticion.value;

    if (datosDelFormulario.importe && datosDelFormulario.cliente) {
      this.peticion = new Peticion;
      this.isLoading = true;

      this.peticion.importe = datosDelFormulario.importe;
      this.peticion.cliente = datosDelFormulario.cliente;
      this.peticion.operacion = "venta";

      // Usa comillas invertidas ` ` y la sintaxis ${variable}, sintaxis pedida por Angular/TypeScript
      let cadena = `${this.peticion.operacion}${this.peticion.importe}${this.peticion.cliente}`;

      //calculo de sha
      this.hashSHA512(cadena).then(hashCalculado => {
        if (this.peticion) {
          this.peticion.sha = hashCalculado;
          console.log("Peticion lista: ", this.peticion);
          this.service.realizarPeticion(this.peticion).subscribe({
            next: (data) => {
              this.respuesta = data;
              this.isLoading = false;
              this.transaccionExitosa = true;
            },
            error: (error: HttpErrorResponse) => {
              if (error.status === 400 || error.status === 500 || error.status === 409 || error.status === 503) {
                this.mensajeError = error.error;
                console.log("error: ", error);
                this.isLoading = false;
              } else {
                //Otros errores,
                this.mensajeError = 'Tenemos problemas con el sistema. Intentalo de nuevo más tarde. ';
                console.log('Back: ', error);
                this.isLoading = false;
              }
            }
          });
        }
      });
    }
  }

  async hashSHA512(message: string): Promise<string> {
    // Codifica el string a un ArrayBuffer usando UTF-8
    const encoder = new TextEncoder();
    const data = encoder.encode(message);

    // Genera el hash SHA-512 usando la API nativa
    const hashBuffer = await crypto.subtle.digest('SHA-512', data);

    // Convierte el ArrayBuffer a una cadena hexadecimal
    const hashArray = Array.from(new Uint8Array(hashBuffer));
    const hashHex = hashArray.map(b => ('00' + b.toString(16)).slice(-2)).join('');

    return hashHex;
  }

}
