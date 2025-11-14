import { Routes } from '@angular/router';
import { ConsultaLiquidez } from './Componentes/consulta-liquidez/consulta-liquidez';
import { RetiroEfectivo } from './Componentes/retiro-efectivo/retiro-efectivo';
import { EntregarEfectivo } from './Componentes/entregar-efectivo/entregar-efectivo';

export const routes: Routes = [
    {
        path : 'consultaEfectivoDisp', component: ConsultaLiquidez
    },
    {
        path : 'retirarEfectivo', component: RetiroEfectivo
    },
    {
        path : 'entregaEfectivo', component: EntregarEfectivo
    }
];
