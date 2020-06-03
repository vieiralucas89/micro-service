package com.microserive.fornecedor.repository;

import com.microserive.fornecedor.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeditoRepository extends JpaRepository<Pedido, Long> {

}
