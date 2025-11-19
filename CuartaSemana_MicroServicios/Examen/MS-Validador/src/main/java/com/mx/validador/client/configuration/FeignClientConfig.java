package com.mx.validador.client.configuration;

import com.mx.validador.errordecoder.TransaccionErrorDecoder;
import feign.Logger;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignClientConfig {

    //Nos permitira ver log
    @Bean
    Logger.Level feignLoggerLevel(){ return Logger.Level.FULL; }

    /*Registrara el ErrorDecoder como bean*/
    @Bean
    public ErrorDecoder errorDecoder(){
        return new TransaccionErrorDecoder();
    }
}
