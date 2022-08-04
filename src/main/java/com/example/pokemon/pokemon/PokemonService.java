package com.example.pokemon.pokemon;

import com.example.pokemon.Trainer.Trainer;
import com.example.pokemon.exceptions.*;
import com.example.pokemon.move.Move;
import com.example.pokemon.move.MoveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PokemonService {

    private final PokemonRepository pokemonRepository;
    private final MoveRepository moveRepository;

    @Autowired
    public PokemonService(PokemonRepository pokemonRepository, MoveRepository moveRepository) {
        this.pokemonRepository = pokemonRepository;
        this.moveRepository = moveRepository;
    }





    public void addPokemon(Pokemon pokemon){
        //create short-lived object to avoid concurrency pitfalls
        PokemonValidator pokemonValidator = new PokemonValidator();
        try {
            pokemonValidator.validate(pokemon);
            pokemonRepository.save(pokemon);
        } catch (EmptyPokemonNameException | IllegalPokemonLevelException e) {
            throw new RuntimeException(e);
        }
    }

    public void deletePokemon(Long pokemonId)
    {
        pokemonRepository.deleteById(pokemonId);
    }

    public void deleteTrainerFromPokemons(Trainer trainer)
    {
        ArrayList<Pokemon> pokemons = (ArrayList<Pokemon>) pokemonRepository.findAll();
        pokemons.forEach((x)->{x.deleteTrainer(trainer);
        pokemonRepository.save(x);});
    }



    public void addMoveToPokemon(Long pokemonId, Move move)
    {
        Optional<Pokemon> pokemonToUpdateOPT = pokemonRepository.findById(pokemonId);
        if(pokemonToUpdateOPT.isPresent())
        {
            Pokemon pokemonToUpdate = pokemonToUpdateOPT.get();
            if(pokemonToUpdate.getMoves().size() < 4)
                //throw error
                pokemonToUpdate.addMove(move);
            pokemonRepository.save(pokemonToUpdate);
        }
    }

    public void deleteMoveFromPokemon(Move move)
    {
        ArrayList<Pokemon> pokemons = (ArrayList<Pokemon>) pokemonRepository.findAll();
        pokemons.forEach((x)->{x.deleteMove(move);
            pokemonRepository.save(x);});
    }

    public List<Pokemon> getAllPokemon() {
        return pokemonRepository.findAll();
    }

    public List<Pokemon> getPokemonWithMoves() {
        return pokemonRepository.getPokemonWithMoves();
    }

    public Pokemon getPokemonById(Long pokemonId)
    {

        Optional<Pokemon> pokemonOptional = pokemonRepository.findById(pokemonId);
        return pokemonOptional.orElse(null);
    }

    public void addTrainerToPokemon(Long pokemonId, Trainer trainer) {
        Optional<Pokemon> pokemonToUpdateOPT = pokemonRepository.findById(pokemonId);
        if(pokemonToUpdateOPT.isPresent())
        {
            Pokemon pokemonToUpdate = pokemonToUpdateOPT.get();
            pokemonToUpdate.addTrainer(trainer);
            pokemonRepository.save(pokemonToUpdate);
        }
    }

    public List<Pokemon> getPokemonWithoutMoves() {
        return pokemonRepository.getPokemonWithoutMoves();
    }

    public void addCustomPokemon(Integer id, List<Integer> movesId, Integer level) {
        Optional<Pokemon> pokemonOPT = pokemonRepository.findById(id.longValue());
        if(pokemonOPT.isPresent())
        {
            Pokemon pokemonCopy = pokemonOPT.get();
            Pokemon pokemon = new Pokemon(pokemonCopy.getName(),pokemonCopy.getType1(),pokemonCopy.getType2(),pokemonCopy.getImageSprite(),level,pokemonCopy.getItem());
            movesId.forEach((moveId) -> {
                Optional<Move> moveOPT = moveRepository.findById(moveId.longValue());
                if(moveOPT.isPresent()) {
                    Move move = moveOPT.get();
                    pokemon.addMove(move);
                }
            });
            System.out.println("sal");
            pokemonRepository.save(pokemon);
        }

    }
}
