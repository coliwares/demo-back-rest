package com.demo.pokedex.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class PokemonPastAbilites {
    @JsonProperty("is_hidden")
    private boolean is_hidden;
    private int slot;
    private Ability ability;

}
