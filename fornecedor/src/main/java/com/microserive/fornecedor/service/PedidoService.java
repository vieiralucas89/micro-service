package com.microserive.fornecedor.service;

import com.microserive.fornecedor.dto.ItemDoPedidoDTO;
import com.microserive.fornecedor.model.Pedido;
import com.microserive.fornecedor.model.PedidoItem;
import com.microserive.fornecedor.model.PedidoStatus;
import com.microserive.fornecedor.model.Produto;
import com.microserive.fornecedor.repository.PedidoRepository;
import com.microserive.fornecedor.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PedidoService {


    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Pedido> getPedidoPorEstado() {
        return pedidoRepository.findAll();

    }

    public Pedido getPedidoPorId(Long id) {
        return this.pedidoRepository.findById(id).orElse(new Pedido());
    }

    public Pedido realizaPedido(List<ItemDoPedidoDTO> itens) {
        if (itens == null) {
            return null;
        }
        List<PedidoItem> pedidoitens = toPedidoItem(itens);
        Pedido pedido = new Pedido(pedidoitens);
        pedido.setTempoDePreparo(itens.size());
        return pedidoRepository.save(pedido);
    }

    private List<PedidoItem> toPedidoItem(List<ItemDoPedidoDTO> itens) {
        Pedido pedido = new Pedido();
        pedido.setStatus(PedidoStatus.RECEBIDO);
        pedido.setTempoDePreparo(40);

        List<Long> idsProduto = itens.stream().map(item -> item.getId()).collect(Collectors.toList());
        List<Produto> produtosPedido = produtoRepository.findByIdIn(idsProduto);

        List<PedidoItem> pedidoitens = itens.stream()
                .map(ittem -> {
                    Produto produto = produtosPedido.stream().filter(p -> p.getId() == ittem.getId()).findFirst().get();

                    PedidoItem pedidoItem = new PedidoItem();
                    pedidoItem.setProduto(produto);
                    pedidoItem.setQuantidade(ittem.getQuantidade());
                    return pedidoItem;
                }).collect(Collectors.toList());

        return pedidoitens;

    }

}
