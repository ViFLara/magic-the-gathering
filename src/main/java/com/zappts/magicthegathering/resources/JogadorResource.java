package com.zappts.magicthegathering.resources;

import com.zappts.magicthegathering.dto.JogadorDTO;
import com.zappts.magicthegathering.entities.Jogador;
import com.zappts.magicthegathering.services.JogadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/jogadores")
@CrossOrigin
public class JogadorResource {
    @Autowired
    private JogadorService service;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void save(@RequestBody @Valid Jogador jogador) {
        service.save(jogador);
    }

    @PostMapping(path = "/create-card-list")
    @ResponseStatus(HttpStatus.OK)
    public void createListsCartas(@RequestBody @Valid JogadorDTO request) {
        service.salvarListaParaJogadorExistente(request);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Jogador> findAll() {
        return service.findAll();
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Jogador> findById(@PathVariable Long id) {
        return service.findById(id);
    }
}




