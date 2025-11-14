package com.mx.Celular.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PruebasController {
    @RequestMapping("/")
    public @ResponseBody String greeting(){
        return "Hola, Mundo";
    }
}
