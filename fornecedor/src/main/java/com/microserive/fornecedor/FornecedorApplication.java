package com.microserive.fornecedor;

import com.microserive.fornecedor.model.Pedido;
import com.microserive.fornecedor.model.PedidoItem;
import com.microserive.fornecedor.model.PedidoStatus;
import com.microserive.fornecedor.model.Produto;
import com.microserive.fornecedor.repository.InfoRepository;
import com.microserive.fornecedor.repository.PedidoItemRepository;
import com.microserive.fornecedor.repository.PeditoRepository;
import com.microserive.fornecedor.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableEurekaClient
public class FornecedorApplication {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private PeditoRepository peditoRepository;

    @Autowired
    private PedidoItemRepository pedidoItemRepository;

    @Autowired
    private InfoRepository infoRepository;

    public static void main(String[] args) {
        SpringApplication.run(FornecedorApplication.class, args);
    }

    @Bean
    public void insertDados() {

        List<PedidoItem> itemsPedido = new ArrayList<>();

        Produto produto = new Produto();
        produto.setId(null);
        produto.setDescricao("Banana");
        produto.setNome("Banana Prata");
        produto.setPreco(1.22);
        produto.setEstado("GO");
        produtoRepository.save(produto);

        Pedido pedido2 = new Pedido();
        pedido2.setId(null);
        pedido2.setStatus(PedidoStatus.ENVIADO);
        pedido2.setTempoDePreparo(40);

        Pedido pedido = new Pedido();
        pedido.setId(null);
        pedido.setStatus(PedidoStatus.PRONTO);
        pedido.setTempoDePreparo(40);

        PedidoItem pedidoItem = new PedidoItem();
        pedidoItem.setId(null);
        pedidoItem.setProduto(produto);
        pedidoItem.setQuantidade(10);

        itemsPedido.add(pedidoItem);
        pedido.setItens(itemsPedido);

        peditoRepository.save(pedido);
        peditoRepository.save(pedido2);
        pedidoItemRepository.save(pedidoItem);


    }

}
