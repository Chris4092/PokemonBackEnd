package com.example.pokemon.Trainer;

import com.example.pokemon.pokemon.Pokemon;
import com.example.pokemon.pokemon.PokemonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class TrainerConfig {
    @Bean
    CommandLineRunner commandLineRunnerTrainer(TrainerRepository trainerRepository)
    {
        return args -> {
        };
    }
}
