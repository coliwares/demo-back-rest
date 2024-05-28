package com.demo.pokedex.model;

import lombok.Data;

@Data
public class PokemonMove {
    private NamedAPIResource move;
    private VersionGroupDetails[] version_group_details;
}
