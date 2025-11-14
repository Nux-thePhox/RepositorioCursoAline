package com.mx.Celular;

import com.mx.Celular.Dao.ICelularDao;
import com.mx.Celular.Dominio.Celular;
import com.mx.Celular.Service.CelularServiceImp;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
@Transactional //Rollback automatico despues de cada test
@TestPropertySource(locations = "classpath:application.properties")
public class IntegracionTest {

    @Autowired
    private CelularServiceImp celularServiceImp;

    @Autowired
    private ICelularDao celularDao;

    @BeforeEach
    void setUp(){
        celularDao.deleteAll();//para comenzar ocon una BD vacia en cada test
    }

    @Test
    void guardarExitoTest(){
        Celular cel = new Celular();
        cel.setMarca("Samsung");
        cel.setModelo("Galaxy s23");
        cel.setRam("8gb");
        cel.setProcesador("Snapdragon");
        cel.setPrecio(2500);

        celularServiceImp.guardar(cel);

        assertTrue(cel.getIdCelular() > 0, "el id se genero automaticamente");

        Celular guardado = celularDao.findById(cel.getIdCelular())
                .orElseThrow(() -> new AssertionError("Deberia existir y por lo tanto buscar"));

        assertNotNull(guardado);
        assertEquals("Samsung", guardado.getMarca());
        assertEquals("Galaxy s23", guardado.getModelo());
        assertEquals("8gb", guardado.getRam());
        assertEquals("Snapdragon", guardado.getProcesador());
        assertEquals(2500, guardado.getPrecio());
    }

    //buscar si existe
    @Test
    void buscarPorIdTest(){
        Celular cel = new Celular();
        cel.setMarca("Xiaomi");
        cel.setModelo("Redmi Notes 12");
        cel.setRam("8gb");
        cel.setProcesador("Mediatek");
        cel.setPrecio(6500);
        celularServiceImp.guardar(cel);
        int idCel = cel.getIdCelular();

        //validar
        Optional<Celular> encontrado = celularDao.findById(idCel);

        assertTrue(encontrado.isPresent(), "Deberia encontrar el id");
        assertEquals("Xiaomi", encontrado.get().getMarca());
    }

    //Buscar y esperar que el id no exista
    @Test
    void celularBuscadoNoExisteTest(){
        Optional<Celular> noEncontrado = celularDao.findById(18);
        assertFalse(noEncontrado.isPresent(), "No deberia encontrar");
    }

    //Verificar que el metodo de mostrar si retorne la lista
    @Test
    void findAllTest(){
        celularServiceImp.guardar(new Celular("Apple", "iPhone15", "6gb", "a16", 20000));
        celularServiceImp.guardar(new Celular("Motorola", "Gpower", "4gb", "Snapdragon", 5000));

        List<Celular> celulares = (List<Celular>) celularDao.findAll();

        assertEquals(2, celulares.size(), "Deberian existir 2");
        assertTrue(celulares.stream().anyMatch(
                c-> "Apple".equals(c.getMarca())
        ));
        assertTrue(celulares.stream().anyMatch(
                c-> "Motorola".equals(c.getMarca())
        ));
    }
}
