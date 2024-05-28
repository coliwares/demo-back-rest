package com.demo.pokedex.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.pokedex.model.Pokemon;
import com.demo.pokedex.service.PokemonService;
import com.demo.pokedex.service.PokemonServiceImpl;



@CrossOrigin
@RestController
@RequestMapping("/pokedex")
public class PokedexRestController {

    @RequestMapping(value="saludo")
    public ResponseEntity<String> saludo() {
        return ResponseEntity.ok("Hola desde el REST controller");
    }

     @RequestMapping(value="getPokemon/{id}", method = RequestMethod.GET)
    public ResponseEntity<Pokemon> getPokemon(@PathVariable String id) {
        System.out.println("Fetching Pokemon details for id: " + id + " in the REST controller");
        PokemonService pokedexService = new PokemonServiceImpl();
        Pokemon pokemon = pokedexService.getPokemon(id);
        return ResponseEntity.ok(pokemon);
    }

}
