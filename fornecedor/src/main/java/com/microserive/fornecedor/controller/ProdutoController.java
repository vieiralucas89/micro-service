package com.microserive.fornecedor.controller;

import com.microserive.fornecedor.model.Produto;
import com.microserive.fornecedor.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping("/{estado}")
    public Produto getProdutosPorEstado(@PathVariable String estado) {
        return produtoService.getProdutosPorEstado(estado);
    }
}
