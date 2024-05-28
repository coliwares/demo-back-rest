package com.demo.pokedex.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class PokemonMove {
    private Move move;
    @JsonProperty("version_group_details")
    private VersionGroupDetails[] version_group_details;
}
