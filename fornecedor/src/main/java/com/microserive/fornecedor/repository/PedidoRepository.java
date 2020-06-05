package com.microserive.fornecedor.repository;

import com.microserive.fornecedor.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    @Query("select p from Pedido p")
    Pedido findByEstado(String estado);

}
