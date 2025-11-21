package com.example.ExamenMoc;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class ExamenMocController {

    @GetMapping
    public String bienvenida(){
        return "Hola, estoy haciendo un examen";
    }
}
