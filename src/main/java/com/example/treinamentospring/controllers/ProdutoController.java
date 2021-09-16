package com.example.treinamentospring.controllers;

import com.example.treinamentospring.model.entities.Produto;
import com.example.treinamentospring.model.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    /*
    @PostMapping
    public @ResponseBody Produto novoProduto(@RequestParam String nome,
                                             @RequestParam double preco,
                                             @RequestParam double desconto){
        Produto produto = new Produto(nome, preco, desconto);
        produtoRepository.save(produto);
        return produto;
    }
    */

    //@PostMapping
    @RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
    public @ResponseBody Produto novoProduto(@Valid Produto produto) {
        produtoRepository.save(produto);
        return produto;
    }

    @GetMapping
    public Iterable<Produto> obterProdutos(){

        return produtoRepository.findAll();
    }

    @GetMapping(path = "/nome/{parteNome}")
    public Iterable<Produto> obterProdutosPorNome(@PathVariable String parteNome){
        return produtoRepository.findByNomeContainingIgnoreCase(parteNome);
    }

    @GetMapping(path = "/{id}")
    public Optional<Produto> obterProdutoId(@PathVariable int id){
        return produtoRepository.findById(id);
    }

    @DeleteMapping(path = "/{id}")
    public void excluirProdutoId(@PathVariable int id){
        produtoRepository.deleteById(id);
    }

    @GetMapping(path = "/pagina/{numeroPagina}/{qtdPaginas}")
    public Iterable<Produto> obterProdutosPorPagina(@PathVariable int numeroPagina,
                                                    @PathVariable int qtdPaginas){
        if(qtdPaginas >= 5) qtdPaginas = 5;
        Pageable page = PageRequest.of(numeroPagina,2);
        return produtoRepository.findAll(page);
    }

    /*
    @PutMapping
    public Produto alterarProduto(@Valid Produto produto){
        produtoRepository.save(produto);
        return produto;
    }
    */
}
