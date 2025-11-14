import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Cantidad } from '../Entidades/Cantidad';

@Injectable({
  providedIn: 'root',
})
export class WS {
  constructor(private http: HttpClient){}
  url = "http://localhost:8006/cajero";

  mostrarFondosDisponibles(){
    return this.http.get<number>(this.url);
  }

  realizaRetiroEfectivo(monto: number){
    let montoParams = new HttpParams();
    montoParams = montoParams.append('monto', monto.toString());
    return this.http.get<Cantidad[]>(this.url+"/retiro", {params : montoParams});
  }
}
