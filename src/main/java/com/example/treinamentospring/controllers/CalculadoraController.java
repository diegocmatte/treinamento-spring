package com.example.treinamentospring.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calculadora")
public class CalculadoraController {

    @GetMapping("/somar/{a}/{b}")
    public int soma(@PathVariable int a,
                    @PathVariable int b){
        return a+b;
    }

    @GetMapping
    public int subtrair(@RequestParam(name = "a") int a,
                        @RequestParam(name = "b") int b){
        return a-b;
    }

}
