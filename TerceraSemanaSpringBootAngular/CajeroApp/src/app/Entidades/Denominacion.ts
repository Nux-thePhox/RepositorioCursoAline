import {TipoMoneda} from "./TipoMoneda"

export class Denominacion{
    idDenominacion !: number;
    tipoMonedaId !: TipoMoneda;
    valor !: number;
}