package com.demo.pokedex.model;

import lombok.Data;

@Data
public class PokemonAbility {
    private boolean is_hidden;
    private int slot;
    private NamedAPIResource ability;


}
