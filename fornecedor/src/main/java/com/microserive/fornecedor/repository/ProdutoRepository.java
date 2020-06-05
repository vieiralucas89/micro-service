package com.microserive.fornecedor.repository;

import com.microserive.fornecedor.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    Produto findByEstado(String estado);

    List<Produto> findByIdIn(List<Long> idsProduto);
}
