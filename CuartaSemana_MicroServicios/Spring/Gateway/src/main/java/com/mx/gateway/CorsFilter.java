package com.mx.gateway;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//Cuando se ocupa esta configuracion, no se deben usar las etiquetas CrossOrigin en los MS.
@Configuration
public class CorsFilter implements WebMvcConfigurer {

    //Se le permite el tipo de solicitudes al dominio 4200
    @Bean
    public WebMvcConfigurer corsConfiguration(){
        return new WebMvcConfigurer() {
            public void addCorsMapping(CorsRegistry registry){
                registry.addMapping("/**")
                        .allowedOrigins("http://localhost:4200")//este es el dominio por defecto de Angular
                        .allowedMethods("GET", "POST", "PUT", "DELETE")
                        .allowedHeaders("*")
                        .allowCredentials(true) //Solo cuando se usa seguridad
                        .maxAge(3600);
            }
        };
    }
}
