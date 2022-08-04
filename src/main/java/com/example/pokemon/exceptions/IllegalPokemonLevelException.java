package com.example.pokemon.exceptions;

public class IllegalPokemonLevelException extends Exception {
    public String errorMessage()
    {
        return "Pokemon level must be an integer between 1 and 100!";
    }
}
