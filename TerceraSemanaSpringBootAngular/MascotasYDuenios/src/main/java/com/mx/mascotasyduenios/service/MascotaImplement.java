package com.mx.mascotasyduenios.service;

import com.mx.mascotasyduenios.dao.IMascotaDao;
import com.mx.mascotasyduenios.dominio.Mascota;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MascotaImplement implements IMascotaService {

    @Autowired
    private IMascotaDao mascotaDao;

    @Override
    public List<Mascota> listar() {
        return mascotaDao.findAll(Sort.by(Sort.Direction.ASC, "idMascota"));
    }

    @Override
    public void guardar(Mascota mascota) {
        mascotaDao.save(mascota);
    }

    @Override
    public void editar(Mascota mascota) {
        mascotaDao.save(mascota);
    }

    @Override
    public Mascota buscar(int idMascota) {
        return mascotaDao.findById(idMascota).orElse(null);
    }

    @Override
    public void eliminar(int idMascota) {
        mascotaDao.deleteById(idMascota);
    }

    public List<Mascota> listarPorEspecie(String especieBuscada){
        return mascotaDao.findActiveLoans(especieBuscada);
    }
}
