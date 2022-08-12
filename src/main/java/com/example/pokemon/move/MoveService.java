package com.example.pokemon.move;

import com.example.pokemon.Trainer.Trainer;
import com.example.pokemon.exceptions.DuplicateMoveNameException;
import com.example.pokemon.exceptions.EmptyMoveNameException;
import com.example.pokemon.exceptions.IllegalMovePowerException;
import com.example.pokemon.pokemon.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MoveService {

    private final MoveRepository moveRepository;

    @Autowired
    public MoveService(MoveRepository moveRepository) {
        this.moveRepository = moveRepository;
    }

    public List<Move> getAllMoves() {
        return moveRepository.findAll();
    }

    public void addNewMove(Move move) {
        //create short-lived object to avoid concurrency pitfalls
        MoveValidator moveValidator = new MoveValidator(moveRepository);
        try {
            moveValidator.validate(move);
            moveRepository.save(move);
        } catch (EmptyMoveNameException | DuplicateMoveNameException | IllegalMovePowerException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteMove(Long moveId) {
        moveRepository.deleteById(moveId);
    }

    public void addPokemonToMove(Long moveId, Pokemon pokemon)
    {
        Optional<Move> moveToUpdateOPT = moveRepository.findById(moveId);
        if(moveToUpdateOPT.isPresent())
        {
            Move moveToUpdate = moveToUpdateOPT.get();
            moveToUpdate.addPokemon(pokemon);
            moveRepository.save(moveToUpdate);
        }
    }
    public void deletePokemonFromMove(Pokemon pokemon)
    {
        ArrayList<Move> moves = (ArrayList<Move>) moveRepository.findAll();
        moves.forEach((x)->{
            x.deletePokemon(pokemon);
            moveRepository.save(x);
        });
    }
    public Move getMoveById(Long moveId)
    {

        Optional<Move> moveOptional = moveRepository.findById(moveId);
        return moveOptional.orElse(null);
    }
}

