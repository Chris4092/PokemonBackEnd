package com.example.pokemon.exceptions;

public class EmptyPokemonLevelException extends Exception{
    public String errorMessage()
    {
        return "Pokemon level must not be left empty!";
    }
}
