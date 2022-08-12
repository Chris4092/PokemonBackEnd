package com.example.pokemon.pokemon;

import com.example.pokemon.DTO.PokemonMoveDTO;
import com.example.pokemon.Trainer.TrainerService;
import com.example.pokemon.move.Move;
import com.example.pokemon.move.MoveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(path = "/api/pokemon")
public class PokemonController {
    private final PokemonService pokemonService;
    private final MoveService moveService;

    private final TrainerService trainerService;

    @Autowired
    public PokemonController(PokemonService pokemonService, MoveService moveService, TrainerService trainerService) {
        this.pokemonService = pokemonService;
        this.moveService = moveService;
        this.trainerService = trainerService;
    }

    @GetMapping
    public List<Pokemon> getAllPokemon()
    {
        return pokemonService.getAllPokemon();
    }

    @GetMapping(path = "/with-moves")
    public List<Pokemon> getAllPokemonWithMoves()
    {
        return pokemonService.getPokemonWithMoves();
    }

    @GetMapping(path = "/without-moves")
    public List<Pokemon> getAllPokemonWithoutMoves()
    {
        return pokemonService.getPokemonWithoutMoves();
    }

    @PostMapping
    public void addNewPokemon(@RequestBody Pokemon pokemon) {pokemonService.addPokemon(pokemon);}

    @PostMapping(path = "/create")
    public void addNewCustomPokemon(@RequestBody PokemonMoveDTO pokemonMoveDTO) {
        pokemonService.addCustomPokemon(pokemonMoveDTO.getId(), pokemonMoveDTO.getIdList(), pokemonMoveDTO.getLevel());
    }



    @DeleteMapping(path = "{pokemonId}")
    public void deletePokemon(@PathVariable("pokemonId") Long pokemonId)
    {
        Pokemon pokemon = pokemonService.getPokemonById(pokemonId);
        trainerService.deletePokemonFromTrainer(pokemon);
        moveService.deletePokemonFromMove(pokemon);
        pokemonService.deletePokemon(pokemonId);
    }

    @PutMapping(path = "/{pokemonId}/moves/{moveId}")
    public void AddMoveToPokemon(@PathVariable Long pokemonId, @PathVariable Long moveId)
    {
        Move move = moveService.getMoveById(moveId);
        Pokemon pokemon = pokemonService.getPokemonById(pokemonId);
        if(pokemon!=null && move!=null) {
            pokemonService.addMoveToPokemon(pokemonId, move);
            moveService.addPokemonToMove(moveId, pokemon);
        }
    }
}
