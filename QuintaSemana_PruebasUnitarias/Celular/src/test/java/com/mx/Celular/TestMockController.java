package com.mx.Celular;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/*
* Mockmvc configura nuestro test para probar controladores*/

@SpringBootTest
@AutoConfigureMockMvc
public class TestMockController {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testMockMessaggeDefault() throws Exception{
        this.mockMvc.perform(get("/"))//simula la solicitud http get
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Hola, Mundo")));
    }
}
