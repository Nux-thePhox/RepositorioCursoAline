import { Routes } from '@angular/router';
import { ListarCelular } from './Componentes/listar-celular/listar-celular';
import { EditarCelular } from './Componentes/editar-celular/editar-celular';
import { GuardarCelular } from './Componentes/guardar-celular/guardar-celular';

export const routes: Routes = [
    {
        path : 'listarC', component: ListarCelular
    },
    {
        path : 'guardarC', component: GuardarCelular
    },
    {
        path: 'editarC', component: EditarCelular
    }
];
