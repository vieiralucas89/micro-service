package com.microserive.loja.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InfoFornecedorDto {

    private Long id;
    private String nome;
    private String estado;
    private String endereco;
}
