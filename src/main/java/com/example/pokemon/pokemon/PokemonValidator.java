package com.example.pokemon.pokemon;

import com.example.pokemon.exceptions.EmptyPokemonNameException;
import com.example.pokemon.exceptions.IllegalPokemonLevelException;

public class PokemonValidator {
    public PokemonValidator(){}

    public void validate(Pokemon pokemon) throws EmptyPokemonNameException, IllegalPokemonLevelException {
        if(pokemon.getName() == "")
        {
            throw new EmptyPokemonNameException();
        }
        if(pokemon.getLevel() <= 0 || pokemon.getLevel()>=101)
        {
            throw new IllegalPokemonLevelException();
        }

    }
}
