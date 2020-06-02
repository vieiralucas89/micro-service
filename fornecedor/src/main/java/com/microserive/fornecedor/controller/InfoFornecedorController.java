package com.microserive.fornecedor.controller;

import com.microserive.fornecedor.model.InfoFornecedor;
import com.microserive.fornecedor.service.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/info")
public class InfoFornecedorController {

    @Autowired
    private FornecedorService fornecedorService;

    @GetMapping("/{estado}")
    public InfoFornecedor getInforPorEstado(@PathVariable String estado) {
        return fornecedorService.getInfoPorEstado(estado);
    }

}
