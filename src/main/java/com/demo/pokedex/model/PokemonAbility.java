package com.demo.pokedex.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class PokemonAbility {
    @JsonProperty("is_hidden")
    private boolean is_hidden;
    private int slot;
    private Ability ability;


}
