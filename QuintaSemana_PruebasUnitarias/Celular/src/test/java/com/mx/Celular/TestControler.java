package com.mx.Celular;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

/*
* RandomPort coloca al servidor Spring en un puerto aleatorio para evitar conlictos
* SpringBootTest proporciona un contexto de prueba completo para la aplicacion*/
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class TestControler {

    //Inyecta el puerto asignado cuando se construya el URL(cuando inicie la aplicacion)
    @LocalServerPort
    private int port;

    @Autowired
    TestRestTemplate restTemplate; //permite enviar solicitudes http simuladas y obtener respuestas

    @Test
    void MessageReturnsDefaultMessage()throws Exception{
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/", String.class))
                .contains("Hola, Mundo");
    }
}
