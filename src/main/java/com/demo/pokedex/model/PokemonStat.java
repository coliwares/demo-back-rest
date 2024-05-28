package com.demo.pokedex.model;

import com.fasterxml.jackson.annotation.JsonAlias;

import lombok.Data;

@Data
public class PokemonStat {
    @JsonAlias("base_stat")
    private int base_stat;
    private int effort;
    private PokemonUrl stat;
}
