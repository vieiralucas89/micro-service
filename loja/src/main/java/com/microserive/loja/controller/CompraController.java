package com.microserive.loja.controller;

import com.microserive.loja.dto.CompraDto;
import com.microserive.loja.dto.InfoFornecedorDto;
import com.microserive.loja.service.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/compra")
public class CompraController {

    @Autowired
    private CompraService compraService;

    @PostMapping
    public InfoFornecedorDto realizaCompra(@RequestBody CompraDto compra) {
        return compraService.realizaCompra(compra);
    }

}
