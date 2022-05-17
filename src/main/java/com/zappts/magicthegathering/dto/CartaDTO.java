package com.zappts.magicthegathering.dto;

import com.zappts.magicthegathering.entities.Carta;
import com.zappts.magicthegathering.entities.Jogador;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CartaDTO {

    private String nome;

    private String edicao;

    private String idioma;

    private Boolean laminada;

    private BigDecimal preco;

    private Long quantidade;

}
