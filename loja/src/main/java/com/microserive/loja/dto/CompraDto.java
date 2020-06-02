package com.microserive.loja.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CompraDto {

    private List<ItensDto> itens;
    private EnderecoDto endereco;
}
