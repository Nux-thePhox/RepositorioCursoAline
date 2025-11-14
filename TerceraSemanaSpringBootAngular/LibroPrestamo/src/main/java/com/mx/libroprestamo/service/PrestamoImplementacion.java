package com.mx.libroprestamo.service;

import com.mx.libroprestamo.dao.IPrestamoDao;
import com.mx.libroprestamo.dominio.Prestamo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PrestamoImplementacion implements IPrestamoService{

    @Autowired
    IPrestamoDao prestamoDao;

    @Override
    public List<Prestamo> listar() {
        return prestamoDao.findAll(Sort.by(Sort.Direction.ASC, "idPrestamo"));
    }

    @Override
    public void guardar(Prestamo prestamo) {
        prestamoDao.save(prestamo);
    }

    @Override
    public void editar(Prestamo prestamo) {
        prestamoDao.save(prestamo);
    }

    @Override
    public Prestamo buscar(int idPrestamo) {
        return prestamoDao.findById(idPrestamo).orElse(null);
    }

    @Override
    public void eliminar(int idPrestamo) {
        prestamoDao.deleteById(idPrestamo);
    }

    //metodo perzonalizado, obtener prestamos activos
    public List<Prestamo> obtenerPrestamosActivos(){
        LocalDate fechaActual = LocalDate.now();
        return prestamoDao.findActiveLoans(fechaActual);
    }

    //metodo personalizado para editar la fecha fin
    public boolean actualizarFechaFin(int idPrestamo, LocalDate fechaFin){
        int filasActualizadas = prestamoDao.actualizarFechaFin(idPrestamo, fechaFin);
        return filasActualizadas > 0;
    }
}
