package com.zappts.magicthegathering.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JogadorDTO {

    private Long idJogador;

    private List<CartaDTO> cartas;
}
