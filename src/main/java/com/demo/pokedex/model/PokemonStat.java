package com.demo.pokedex.model;

import lombok.Data;

@Data
public class PokemonStat {
    private int base_stat;
    private int effort;
    private NamedAPIResource stat;
}
