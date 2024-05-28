package com.demo.pokedex.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class VersionGroupDetails {
    @JsonProperty("level_learned_at")
    private int level_learned_at;
    @JsonProperty("move_learn_method")
    private Move move_learn_method;
    @JsonProperty("version_group")
    private Version version_group;
}
