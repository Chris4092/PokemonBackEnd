package com.example.pokemon.Trainer;

import com.example.pokemon.DTO.TrainerWithPokemonDTO;
import com.example.pokemon.move.Move;
import com.example.pokemon.pokemon.Pokemon;
import com.example.pokemon.pokemon.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/trainer")
public class TrainerController {

    private final TrainerService trainerService;
    private final PokemonService pokemonService;

    @Autowired
    public TrainerController(TrainerService trainerService, PokemonService pokemonService) {
        this.trainerService = trainerService;
        this.pokemonService = pokemonService;
    }

    @GetMapping
    public List<Trainer> getAllTrainers()
    {
        return trainerService.getAllTrainers();
    }

    @PostMapping
    public void addNewTrainer(@RequestBody Trainer trainer) {trainerService.addTrainer(trainer);}

    @PostMapping(path = "/withPokemonList")
    public void addNewTrainerWithPokemonList(@RequestBody TrainerWithPokemonDTO trainerWithPokemonDTO) {trainerService.addTrainer(trainerWithPokemonDTO.getName(),trainerWithPokemonDTO.getNumber(),trainerWithPokemonDTO.getIdList());}

    @DeleteMapping(path = "{trainerId}")
    public void deleteTrainer(@PathVariable("trainerId") Long trainerId)
    {
        Trainer trainer = trainerService.getTrainerById(trainerId);
        pokemonService.deleteTrainerFromPokemons(trainer);
        trainerService.deleteTrainer(trainerId);
    }

    @PutMapping(path = "/{trainerId}/pokemon/{pokemonId}")
    public void AddPokemonToTrainer(@PathVariable Long trainerId, @PathVariable Long pokemonId)
    {
        Trainer trainer = trainerService.getTrainerById(trainerId);
        Pokemon pokemon = pokemonService.getPokemonById(pokemonId);
        if(pokemon!=null && trainer!=null) {
            pokemonService.addTrainerToPokemon(pokemonId, trainer);
            trainerService.addPokemonToTrainer(trainerId, pokemon);
        }
    }
}
