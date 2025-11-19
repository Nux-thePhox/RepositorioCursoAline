package com.mx.validador.client;

import com.mx.validador.client.configuration.FeignClientConfig;
import com.mx.validador.dto.PeticionDTO;
import com.mx.validador.dto.RespuestaDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "MS-Transaccion",
        url="${transaccion.servicio.url}",
        configuration = FeignClientConfig.class)
public interface ITransaccionFeignConfig {

    @PostMapping
    RespuestaDTO guardarTransaccion(@RequestBody PeticionDTO peticion);
}
