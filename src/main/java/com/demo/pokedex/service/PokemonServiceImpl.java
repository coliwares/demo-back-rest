package com.demo.pokedex.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.demo.pokedex.model.Pokemon;

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
            // Get the Pokemon details from the response body
            Pokemon pokemonApiResponse = response.getBody();

            // Create a new Pokemon object and set its values from the API response
            Pokemon pokemon = new Pokemon();
            pokemon.setId(pokemonApiResponse.getId());
            pokemon.setName(pokemonApiResponse.getName());
            pokemon.setBaseExperience(pokemonApiResponse.getBaseExperience());
            pokemon.setSprites(pokemonApiResponse.getSprites());
            // Set other properties as needed

            return pokemon;
        } else {
            // Handle the error case if the request was not successful
            throw new RuntimeException("Failed to get Pokemon details from the API");
        }
    }

}
