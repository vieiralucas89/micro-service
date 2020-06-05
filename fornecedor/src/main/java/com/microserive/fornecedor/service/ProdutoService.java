package com.microserive.fornecedor.service;

import com.microserive.fornecedor.model.Produto;
import com.microserive.fornecedor.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto getProdutosPorEstado(String estado) {
        return produtoRepository.findByEstado(estado);
    }
}
