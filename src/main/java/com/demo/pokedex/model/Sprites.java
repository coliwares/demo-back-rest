package com.demo.pokedex.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
@Data
public class Sprites {
    @JsonProperty("back_default")
    private String back_default;
    @JsonProperty("back_female")
    private String back_female;
    @JsonProperty("back_shiny")
    private String back_shiny;
    @JsonProperty("back_shiny_female")
    private String back_shiny_female;
    @JsonProperty("front_default")
    private String front_default;
    @JsonProperty("front_female")
    private String front_female;
    @JsonProperty("front_shiny")
    private String front_shiny;
    @JsonProperty("front_shiny_female")
    private String front_shiny_female;
}
