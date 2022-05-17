package com.zappts.magicthegathering.services;

import com.zappts.magicthegathering.entities.Carta;
import com.zappts.magicthegathering.entities.Jogador;
import com.zappts.magicthegathering.repositories.CartaRepository;
import com.zappts.magicthegathering.repositories.JogadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Arrays;

@Service
public class DBService {

    @Autowired
    private CartaRepository cartaRepository;

    @Autowired
    private JogadorRepository jogadorRepository;

    public void instantiateTestDatabase() throws ParseException {

        Carta c1 = Carta.builder().nome("The Lord of the Rings").edicao("Lorem ipsum")
                .idioma("inglês").laminada(true).preco(new BigDecimal(90.3)).quantidade(3L).build();

        Carta c2 = Carta.builder().nome("The Magic").edicao("Dolor sit amet")
                .idioma("japonês").laminada(true).preco(new BigDecimal(200.5)).quantidade(5L).build();

        cartaRepository.saveAll(Arrays.asList(c1, c2));

        Jogador j1 = Jogador.builder().nome("Mara").cartas(Arrays.asList(c1, c2)).build();
        Jogador j2 = Jogador.builder().nome("Carlos").build();
        Jogador j3 = Jogador.builder().nome("Albert").build();

        j1.getCartas().addAll(Arrays.asList(c1, c2));
        j2.getCartas().addAll(Arrays.asList(c1,c2));

        jogadorRepository.saveAll(Arrays.asList(j1, j2, j3));

    }
}

