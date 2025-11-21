import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Peticion } from '../entidades/Peticion';
import { Respuesta } from '../entidades/Respuesta';

@Injectable({
  providedIn: 'root',
})
export class WS {
  constructor(private http: HttpClient){}
  url = "http://localhost:9000";

  realizarPeticion(peticion : Peticion){
    return this.http.post<Respuesta>(this.url+"/ms-validador", peticion, {responseType : "text" as "json"});
  }
}
