package com.example.pokemon.exceptions;

public class DuplicateMoveNameException extends Exception{
    public String errorMessage()
    {
        return "A move with this name already exists";
    }
}
