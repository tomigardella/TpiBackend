package com.backend.api_gateway.controlers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class PublicoController {

    @GetMapping
    public String getPublico(){
        return "Este es un recurso público!";
    }
}
