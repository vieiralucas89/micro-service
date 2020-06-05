package com.microserive.fornecedor.controller;

import com.microserive.fornecedor.dto.ItemDoPedidoDTO;
import com.microserive.fornecedor.model.Pedido;
import com.microserive.fornecedor.model.Produto;
import com.microserive.fornecedor.service.PedidoService;
import com.microserive.fornecedor.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;


    @PostMapping
    public Pedido realizaPedido(@RequestBody List<ItemDoPedidoDTO> items) {
        return pedidoService.realizaPedido(items);
    }

    @GetMapping("/{id}")
    public Pedido getPedidoPorId(@PathVariable Long id) {
        return pedidoService.getPedidoPorId(id);
    }
}
