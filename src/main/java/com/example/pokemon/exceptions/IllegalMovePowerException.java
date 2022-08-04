package com.example.pokemon.exceptions;

public class IllegalMovePowerException extends Exception{
    public String errorMessage()
    {
        return "Please make sure Power is an integer between 0 and 250";
    }
}
