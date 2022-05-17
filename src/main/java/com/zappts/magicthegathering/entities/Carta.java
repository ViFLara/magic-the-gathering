package com.zappts.magicthegathering.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zappts.magicthegathering.dto.CartaDTO;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Builder
@Entity
@Table(name = "carta")
@NoArgsConstructor
@AllArgsConstructor
public class Carta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String edicao;

    private String idioma;

    private Boolean laminada;

    private BigDecimal preco;

    private Long quantidade;

    @ManyToOne
    @JoinColumn(name="jogador_id")
    private Jogador jogador;

    public static Carta convert(CartaDTO cartaDTO, Jogador jogador) {

        return Carta
                .builder()
                .nome(cartaDTO.getNome())
                .edicao(cartaDTO.getEdicao())
                .idioma(cartaDTO.getIdioma())
                .laminada(cartaDTO.getLaminada())
                .preco(cartaDTO.getPreco())
                .quantidade(cartaDTO.getQuantidade())
                .jogador(jogador)
                .build();
    }

    public void setId(Integer id) {
    }

}
