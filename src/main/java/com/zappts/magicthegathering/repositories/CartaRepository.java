package com.zappts.magicthegathering.repositories;

import com.zappts.magicthegathering.entities.Carta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartaRepository extends JpaRepository<Carta, Long> {

}

