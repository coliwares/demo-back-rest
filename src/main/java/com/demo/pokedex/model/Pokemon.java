package com.demo.pokedex.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data; // Import the Data annotation from lombok

@Data
public class Pokemon {
    private int id;
    private String name;
    private int weight;
    private int height;
    private int order;
    @JsonProperty("base_experience")
    private String baseExperience;
    @JsonProperty("is_default")
    private Boolean isDefault;
    @JsonProperty("location_area_encounters")
    private String locationAreaEncounters;
    private PokemonSpecies species;
    private PokemonSprites sprites;
    private PokemonCries cries;
    private PokemonAbility[] abilities;
    private PokemonForm[] forms;
    private PokemonGameIndices[] gameIndices;
    @JsonProperty("held_items")
    private PokemonHeldItem[] heldItems;
    private PokemonMove[] moves;
    @JsonProperty("past_abilities")
    private PokemonPastAbilites[] pastAbilities;
    @JsonProperty("past_types")
    private PokemonTypePast[] pastTypes;
    private PokemonStat[] stats;
    private PokemonType[] types;
}
