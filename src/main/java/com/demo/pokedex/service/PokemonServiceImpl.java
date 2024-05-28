package com.demo.pokedex.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.demo.pokedex.model.Pokemon;
import com.demo.pokedex.model.PokemonAbility;

public class PokemonServiceImpl implements PokemonService {

    @Override
    public Pokemon getPokemon(String id) {

        System.out.println("Fetching Pokemon details for id: " + id);

        // Create a RestTemplate instance
        RestTemplate restTemplate = new RestTemplate();

        // Make a GET request to the PokeAPI with the provided id
        String apiUrl = "https://pokeapi.co/api/v2/pokemon/" + id;
        ResponseEntity<Pokemon> response = restTemplate.getForEntity(apiUrl, Pokemon.class);

        // Check if the request was successful
        if (response.getStatusCode() == HttpStatus.OK) {

            System.out.println(response.getBody());

            // Get the Pokemon details from the response body
            Pokemon pokemon = new Pokemon();

            pokemon.setId(response.getBody().getId());
            pokemon.setName(response.getBody().getName());
            pokemon.setAbilities(response.getBody().getAbilities());
            pokemon.setBaseExperience(response.getBody().getBaseExperience());
            pokemon.setCries(response.getBody().getCries());
            pokemon.setForms(response.getBody().getForms());
            pokemon.setGameIndices(response.getBody().getGameIndices());
            pokemon.setHeight(response.getBody().getHeight());
            pokemon.setHeldItems(response.getBody().getHeldItems());
            pokemon.setIsDefault(response.getBody().getIsDefault());
            pokemon.setLocationAreaEncounters(response.getBody().getLocationAreaEncounters());
            pokemon.setMoves(response.getBody().getMoves());
            pokemon.setOrder(response.getBody().getOrder());
            pokemon.setPastAbilities(response.getBody().getPastAbilities());
            pokemon.setPastTypes(response.getBody().getPastTypes());
            pokemon.setSpecies(response.getBody().getSpecies());
            pokemon.setSprites(response.getBody().getSprites());
            pokemon.setStats(response.getBody().getStats());
            pokemon.setTypes(response.getBody().getTypes());






            

            return pokemon;
        } else {
            // Handle the error case if the request was not successful
            throw new RuntimeException("Failed to get Pokemon details from the API");
        }
    }

}
