package com.demo.pokedex.model;

import lombok.Data; // Import the Data annotation from lombok

@Data
public class Pokemon {
    private int id;
    private String name;
    private int baseExperience;
    private int height;
    private boolean isDefault;
    private int order;
    private int weight;
    private PokemonSprites sprites;
}
