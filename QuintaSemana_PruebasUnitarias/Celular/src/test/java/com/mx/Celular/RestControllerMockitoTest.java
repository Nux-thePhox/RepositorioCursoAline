package com.mx.Celular;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mx.Celular.Controller.CelularController;
import com.mx.Celular.Dominio.Celular;
import com.mx.Celular.Service.CelularServiceImp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CelularController.class)
public class RestControllerMockitoTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private CelularServiceImp mockCelularService;

    @Test
    void testCelularReturnListado()throws Exception{
        //crear akgybis registros
        Celular cel1 = new Celular(1, "Samsung", "Galaxi 2", "32", "Octa-core", 21050);
        Celular cel2 = new Celular(2, "Huawuei", "p30lite", "16", "Octa", 1500);
        List<Celular> celulares = List.of(cel1, cel2);

        //Simulacion: el servicio nos devuelve una lista
        when(mockCelularService.mostrar()).thenReturn(celulares);

        //Conertir la lista en formato JSON
        ObjectMapper objectMapper = new ObjectMapper();
        String listaJson = objectMapper.writeValueAsString(celulares);

        //realizar la solicitud Get al endpoint de mostrar
        this.mockMvc.perform(get("/api/Cel/listar"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(listaJson));
    }

    @Test
    void guardarCelularTest() throws Exception {
        Celular cel1 = new Celular(1, "Samsung", "Galaxi 2", "32", "Octa-core", 21050);
        ObjectMapper objectMapper = new ObjectMapper();
        String celularJson = objectMapper.writeValueAsString(cel1); //Se convierte a json para pasarlo por la peticion
        doNothing().when(mockCelularService).guardar(any(Celular.class));
        this.mockMvc.perform(post("/api/Cel/guardar")
                .contentType(MediaType.APPLICATION_JSON)
                .content(celularJson))
                .andDo(print())
                .andExpect(status().isOk());

        //Verificar que el servicio fue llamado
        verify(mockCelularService, times(1)).guardar(any(Celular.class));
    }

    @Test
    void editarCelularTest() throws Exception{
        Celular cel1 = new Celular(1, "Samsung", "Galaxi 2", "32", "Octa-core", 21050);
        ObjectMapper objectMapper = new ObjectMapper();
        String celularJson = objectMapper.writeValueAsString(cel1); //Se convierte a json para pasarlo por la peticion
        doNothing().when(mockCelularService).editar(any(Celular.class));
        this.mockMvc.perform(put("/api/Cel/editar")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(celularJson))
                .andDo(print())
                .andExpect(status().isOk());

        //Verificar que el servicio fue llamado
        verify(mockCelularService, times(1)).editar(any(Celular.class));
    }

    @Test
    void eliminarCelularTest() throws Exception{
        ObjectMapper objectMapper = new ObjectMapper();
        Celular cel1 = new Celular(1, "Samsung", "Galaxi 2", "32", "Octa-core", 21050);
        String celularJson = objectMapper.writeValueAsString(cel1); //Se convierte a json para pasarlo por la peticion
        doNothing().when(mockCelularService).eliminar(any(Celular.class));
        this.mockMvc.perform(delete("/api/Cel/eliminar")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(celularJson))
                .andDo(print())
                .andExpect(status().isOk());

        //Verificar que el servicio fue llamado
        verify(mockCelularService, times(1)).eliminar(any(Celular.class));
    }

    @Test
    void buscarCelularTest() throws Exception {
        Celular cel1 = new Celular(1, "Samsung", "Galaxi 2", "32", "Octa-core", 21050);
        ObjectMapper objectMapper = new ObjectMapper();
        String celularJson = objectMapper.writeValueAsString(cel1); //Se convierte a json para pasarlo por la peticion
        when(mockCelularService.buscar(any(Celular.class))).thenReturn(cel1);
        this.mockMvc.perform(post("/api/Cel/buscar")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(celularJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(celularJson));
    }

}
