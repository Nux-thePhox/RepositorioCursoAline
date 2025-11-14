import { Routes } from '@angular/router';
import { LibroListar } from './Componentes/Libro/libro-listar/libro-listar';
import { LibroGuardar } from './Componentes/Libro/libro-guardar/libro-guardar';
import { LibroEditar } from './Componentes/Libro/libro-editar/libro-editar';
import { PrestamoListar } from './Componentes/Prestamo/prestamo-listar/prestamo-listar';
import { PrestamoGuardar } from './Componentes/Prestamo/prestamo-guardar/prestamo-guardar';
import { PrestamoEditar } from './Componentes/Prestamo/prestamo-editar/prestamo-editar';

export const routes: Routes = [
    { path: 'listarLibro', component: LibroListar },
    { path: 'listarPrestamo', component: PrestamoListar },
    { path: 'guardarLibro', component: LibroGuardar },
    { path: 'guardarPrestamo', component: PrestamoGuardar },
    { path: 'editarLibro', component: LibroEditar },
    { path: 'editarPrestamo', component: PrestamoEditar },

];
