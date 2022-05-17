package com.zappts.magicthegathering.services;

import com.zappts.magicthegathering.dto.CartaDTO;
import com.zappts.magicthegathering.dto.JogadorDTO;
import com.zappts.magicthegathering.entities.Carta;
import com.zappts.magicthegathering.entities.Jogador;
import com.zappts.magicthegathering.repositories.CartaRepository;
import com.zappts.magicthegathering.repositories.JogadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JogadorService {

    @Autowired
    private JogadorRepository jogadorRepository;
    @Autowired
    private CartaRepository cartaRepository;

    public Optional<Jogador> findById(Long id) {
        Optional<Jogador> foundJogador = jogadorRepository.findById(id);
        return Optional.ofNullable(foundJogador.orElse(null));
    }

    public List<Jogador> findAll() {
        return jogadorRepository.findAll();
    }

    public void save(Jogador jogador) {
        jogadorRepository.save(jogador);
    }

    public void salvarListaParaJogadorExistente(JogadorDTO request) {
        Jogador jogador = jogadorRepository.findById(request.getIdJogador()).get();

        List<CartaDTO> cartasRecebidas = request.getCartas();

        cartaRepository.saveAll(cartasRecebidas.stream()
                .map(carta -> Carta.convert(carta, jogador))
                .collect(Collectors.toList()));

    }
}