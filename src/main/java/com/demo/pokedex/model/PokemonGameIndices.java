package com.demo.pokedex.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class PokemonGameIndices {
    @JsonProperty("game_index")
    private int gameIndex;
    private Version version;
}

