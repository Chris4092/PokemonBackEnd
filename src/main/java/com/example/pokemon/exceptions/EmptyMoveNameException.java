package com.example.pokemon.exceptions;

public class EmptyMoveNameException extends Exception{
    public String errorMessage()
    {
        return "Field name cannot be empty!";
    }
}
