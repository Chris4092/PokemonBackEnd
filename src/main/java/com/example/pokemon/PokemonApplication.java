package com.example.pokemon;

import com.example.pokemon.move.Move;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
public class PokemonApplication {

	public static void main(String[] args) {
		SpringApplication.run(PokemonApplication.class, args);
	}


}
