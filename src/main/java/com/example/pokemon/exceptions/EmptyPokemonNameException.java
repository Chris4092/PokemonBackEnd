package com.example.pokemon.exceptions;

public class EmptyPokemonNameException extends Exception{
    public String errorMessage()
    {
        return "Pokemon name must not be left empty!";
    }
}
