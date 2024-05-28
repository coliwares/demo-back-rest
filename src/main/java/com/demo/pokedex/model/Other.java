package com.demo.pokedex.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
@Data
public class Other {
    @JsonProperty("dream_world")
    private Sprites dream_world;
    private Sprites home;
    @JsonProperty("official-artwork")
    private Sprites officialArtwork;
    private Sprites showdown;
}
