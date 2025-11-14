package com.mx.tienda.templateconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/*La anotacion nos esta definiendo que esta clase contiene una configuración para la aplicacion
* y debe definir uno o mas beans*/
@Configuration
public class RestTemplateConfig {

    @Bean
    RestTemplate restTemplate(){
        return new RestTemplate();
    }

    /*comunicacion asincrona entre ms: Voy a consumir un ms desde otro ms.
      Usando la clase RestTemplate el ms de tienda sera un cliente HTTP
    */


}
