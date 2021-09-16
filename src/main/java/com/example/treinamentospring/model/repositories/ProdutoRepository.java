package com.example.treinamentospring.model.repositories;

import com.example.treinamentospring.model.entities.Produto;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProdutoRepository extends PagingAndSortingRepository<Produto, Integer> {

    public Iterable<Produto> findByNomeContainingIgnoreCase(String nome);
}
