package com.examen.cajero.service.impl;

import com.examen.cajero.dominio.Denominacion;
import com.examen.cajero.dominio.Cantidad;
import com.examen.cajero.dominio.TipoMoneda;
import com.examen.cajero.service.CajeroService;
import com.examen.cajero.service.CantidadService;
import com.examen.cajero.service.DenominacionService;
import com.examen.cajero.service.TipoMonedaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CajeroImpl implements CajeroService {

    @Autowired
    CantidadService cantidadService;

    @Autowired
    DenominacionService denominacionService;

    @Autowired
    TipoMonedaService tipoMonedaService;

    @Override
    public float obtenFondoTotal() {
        return cantidadService.obtenFondoTotal();
    }

    //Devuelve las monedas manejadas en el cajero
    public List<TipoMoneda> obtenMonedas(){
        return tipoMonedaService.listarLasMonedas();
    }

    public List<Denominacion> obtenDenominaciones(){
        return denominacionService.listarDenominaciones();
    }

    //Obtiene la denominaciones que se ajustan al monto
    public List<Cantidad> obtenDenominacionParaRetirar(float monto){
        List<Cantidad> fondosAEntregar = new ArrayList<>();
        Cantidad cantidadAEntregar;
        Denominacion montoExacto = denominacionService.obtenDenominacionPorValor(monto);
        if(montoExacto != null){
            Cantidad cantidadDisponible = cantidadService.obtenCantidadPorDenominacion(montoExacto);
            System.out.println("Se actualizaria: \n "+cantidadDisponible);
            if(cantidadDisponible.getCantidad() > 0){
                cantidadAEntregar =
                        new Cantidad(1, cantidadDisponible.getDenominacionId(), 1);
                fondosAEntregar.add(cantidadAEntregar);
                System.out.println("Se devolvera: \n "+cantidadAEntregar);
                cantidadDisponible.setCantidad(cantidadDisponible.getCantidad() - 1);
                cantidadService.actualizarCantidad(cantidadDisponible);
                return fondosAEntregar;
            }
        }
        //Buscando las denominaciones que cumplan con el monto
        List<Denominacion> denominaciones = denominacionService.listarDenominaciones();
        System.out.println("Denominaciones Disponibles:\n "+denominaciones);
        Cantidad cantidadAActualizar;
        int indexDenominacion = 0;
        int idCantidadEntregar = 0;
        int cantidadDenominacionAEntregar;
        while(monto > 0 && indexDenominacion < denominaciones.size()){
            Denominacion denominacion = denominaciones.get(indexDenominacion);
            cantidadAActualizar = cantidadService.obtenCantidadPorDenominacion(denominacion);
            System.out.println("Cantidad a modificar:\n "+cantidadAActualizar);
            if(monto >= denominacion.getValor() && cantidadAActualizar.getCantidad() > 0){
                cantidadDenominacionAEntregar = 0;
                while(monto >= denominacion.getValor() &&
                        cantidadDenominacionAEntregar < cantidadAActualizar.getCantidad()){
                    monto = monto - denominacion.getValor();
                    cantidadDenominacionAEntregar++;
                }
                cantidadAEntregar = new Cantidad(idCantidadEntregar, denominacion, cantidadDenominacionAEntregar);
                System.out.println("Se devolvera:\n "+cantidadAEntregar);
                fondosAEntregar.add(cantidadAEntregar);
                cantidadAActualizar.setCantidad(cantidadAActualizar.getCantidad() - cantidadDenominacionAEntregar);
                cantidadService.actualizarCantidad(cantidadAActualizar);
                idCantidadEntregar++;
            }
            indexDenominacion++;
        }
        return fondosAEntregar;
    }

}
