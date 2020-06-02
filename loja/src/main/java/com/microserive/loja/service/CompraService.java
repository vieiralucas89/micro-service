package com.microserive.loja.service;

import com.microserive.loja.client.FornecedorClient;
import com.microserive.loja.dto.CompraDto;
import com.microserive.loja.dto.InfoFornecedorDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompraService {


    @Autowired
    private FornecedorClient fornecedorClient;

    public InfoFornecedorDto realizaCompra(CompraDto compraDto) {
        return fornecedorClient.getInforPorEstado(compraDto.getEndereco().getEstado());
    }
}
