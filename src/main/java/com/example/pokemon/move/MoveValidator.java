package com.example.pokemon.move;

import com.example.pokemon.exceptions.DuplicateMoveNameException;
import com.example.pokemon.exceptions.EmptyMoveNameException;
import com.example.pokemon.exceptions.IllegalMovePowerException;

public class MoveValidator {
    private final MoveRepository moveRepository;

    public MoveValidator(MoveRepository moveRepository) {
        this.moveRepository = moveRepository;
    }

    public void validate(Move move) throws EmptyMoveNameException, IllegalMovePowerException, DuplicateMoveNameException {
        if(move.getName().equals("")){
            throw new EmptyMoveNameException();
        }
        if(move.getPower()<0 || move.getPower() > 250){
            throw new IllegalMovePowerException();
        }
        if(moveRepository.findMoveByName(move.getName()).isPresent())
        {
            throw new DuplicateMoveNameException();
        }
    }
}
