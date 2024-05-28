package com.demo.pokedex.model;

import lombok.Data;

@Data
public class PokemonType {
    private int slot;
    private NamedAPIResource type;
}
