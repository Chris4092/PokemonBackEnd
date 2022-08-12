package com.example.pokemon.Trainer;

import com.example.pokemon.exceptions.IllegalTrainerNameException;

public class TrainerValidator {
    public void validate(Trainer trainer) throws IllegalTrainerNameException {
        if(trainer.getName() == "")
        {
            throw new IllegalTrainerNameException();
        }
    }
}
