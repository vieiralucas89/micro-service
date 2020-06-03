package com.microserive.fornecedor.repository;

import com.microserive.fornecedor.model.InfoFornecedor;
import com.microserive.fornecedor.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
