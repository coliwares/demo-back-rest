package com.demo.pokedex.model;

import lombok.Data;

@Data
public class VersionGroupDetails {
    private int level_learned_at;
    private NamedAPIResource move_learn_method;
    private NamedAPIResource version_group;
}
