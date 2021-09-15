package com.example.treinamentospring.controllers;

import com.example.treinamentospring.models.Cliente;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @GetMapping("/qualquer")
    private Cliente obterCliente(){

        return new Cliente(28,"Pedro","123.456.789-00");
    }

    @GetMapping("/{id}")
    public Cliente obterClientePorId(@PathVariable int id){
        return new Cliente(id, "Maria","123.456.789-00");
    }

    @GetMapping
    public Cliente obterClientePorId2(@RequestParam(name = "id", defaultValue = "1") int id){
        return new Cliente(id, "João Augusto","111.222.333-44");
    }
}
