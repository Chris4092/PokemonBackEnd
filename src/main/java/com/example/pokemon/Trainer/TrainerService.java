package com.example.pokemon.Trainer;

import com.example.pokemon.exceptions.IllegalTrainerNameException;
import com.example.pokemon.pokemon.Pokemon;
import com.example.pokemon.pokemon.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TrainerService {
    private final TrainerRepository trainerRepository;
    private final PokemonRepository pokemonRepository;

    @Autowired
    public TrainerService(TrainerRepository trainerRepository, PokemonRepository pokemonRepository) {
        this.trainerRepository = trainerRepository;
        this.pokemonRepository = pokemonRepository;
    }

    public void addTrainer(Trainer trainer){
        //create short-lived object to avoid concurrency pitfalls
        TrainerValidator trainerValidator = new TrainerValidator();
        try {
            trainerValidator.validate(trainer);
            trainerRepository.save(trainer);
        } catch (IllegalTrainerNameException e) {
            throw new RuntimeException(e);
        }
    }

    public void addTrainer(String name, Integer number, List<Integer> idList)
    {
        Trainer trainer = new Trainer(name,false,"normal","",number);
        TrainerValidator trainerValidator = new TrainerValidator();
        try {
            trainerValidator.validate(trainer);
            trainerRepository.save(trainer);
            idList.forEach((x)->{
                    Optional<Pokemon> pokemonOptional = pokemonRepository.findById(x.longValue());
                    if(pokemonOptional.isPresent())
                    {
                        Pokemon pokemon = pokemonOptional.get();
                        trainer.addPokemon(pokemon);
                    }
            });
            trainerRepository.save(trainer);

        } catch (IllegalTrainerNameException ignored) {

        }

    }

    public void deleteTrainer(Long trainerId)
    {
        trainerRepository.deleteById(trainerId);
    }

    public void addPokemonToTrainer(Long trainerId,Pokemon pokemon)
    {
        Optional<Trainer> trainerToUpdateOPT = trainerRepository.findById(trainerId);
        if(trainerToUpdateOPT.isPresent())
        {
            Trainer trainerToUpdate = trainerToUpdateOPT.get();
            if(trainerToUpdate.getPokemons().size() < 6)
                //throw error
                trainerToUpdate.addPokemon(pokemon);
            trainerRepository.save(trainerToUpdate);
        }
    }

    public void deletePokemonFromTrainer(Pokemon pokemon)
    {
        ArrayList<Trainer> trainers = (ArrayList<Trainer>) trainerRepository.findAll();
        trainers.forEach((x)->{
            x.deletePokemon(pokemon);
            trainerRepository.save(x);
        });
    }

    public List<Trainer> getAllTrainers() {
        return trainerRepository.findAll();
    }

    public Trainer getTrainerById(Long trainerId)
    {

        Optional<Trainer> trainerOptional = trainerRepository.findById(trainerId);
        return trainerOptional.orElse(null);
    }


}
