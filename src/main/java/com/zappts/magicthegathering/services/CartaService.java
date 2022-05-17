package com.zappts.magicthegathering.services;

import com.zappts.magicthegathering.entities.Carta;
import com.zappts.magicthegathering.repositories.CartaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartaService {
    @Autowired
    private CartaRepository cartaRepository;

    public Optional<Carta> findById(Long id) {
        Optional<Carta> foundCarta = cartaRepository.findById(id);
        return Optional.ofNullable(foundCarta.orElse(null));
    }

    public List<Carta> findAll() {
        return cartaRepository.findAll();
    }

    public Carta update(Carta carta) {
        Carta updatedCarta = cartaRepository.save(carta);
        return updatedCarta;
    }

    public void deleteById(Long id) throws ChangeSetPersister.NotFoundException {
        verifyIfExists(id);
        cartaRepository.deleteById(id);
    }

    private Carta verifyIfExists(Long id) throws ChangeSetPersister.NotFoundException {
        return cartaRepository.findById(id)
                .orElseThrow(() -> new ChangeSetPersister.NotFoundException());
    }

    public Carta createCarta(Carta cartaEntity) {
        Carta savedCartaEntity = cartaRepository.save(cartaEntity);
        return savedCartaEntity;
    }
}
