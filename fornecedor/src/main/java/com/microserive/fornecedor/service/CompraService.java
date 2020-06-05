package com.microserive.fornecedor.service;

import com.microserive.fornecedor.model.InfoFornecedor;
import com.microserive.fornecedor.repository.InfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompraService {

    @Autowired
    private InfoRepository infoRepository;

    public InfoFornecedor getInfoPorEstado(String estado) {
        return infoRepository.findByEstado(estado);
    }
}
