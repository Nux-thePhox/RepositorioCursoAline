import { Libro } from "./Libro";

export class Prestamo{
    idPrestamo !: number;
    fechaInicio !: Date;
    fechaFin !: Date;
    libroId !: Libro;
}