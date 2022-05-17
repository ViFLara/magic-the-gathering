package com.zappts.magicthegathering.resources;

import com.zappts.magicthegathering.entities.Carta;
import com.zappts.magicthegathering.services.CartaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/cartas")
public class CartaResource {
    @Autowired
    private CartaService service;

    @GetMapping
    public ResponseEntity<List<Carta>> findAll() {
        List<Carta> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Carta>> findById(@PathVariable Long id) {
        Optional<Carta> obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Carta createCarta(@RequestBody Carta carta)  {
        return service.createCarta(carta);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody Carta carta, @PathVariable Integer id) {
        carta.setId(id);
        carta = service.update(carta);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws ChangeSetPersister.NotFoundException {
        service.deleteById(id);
    }

}
