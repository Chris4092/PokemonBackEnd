package com.example.pokemon.pokemon;


import com.example.pokemon.move.Move;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

@Configuration
public class PokemonConfig {
    @Bean
    CommandLineRunner commandLineRunnerPokemon(PokemonRepository pokemonRepository)
    {
        return args -> {
            File file = new File("C:\\Users\\chris\\Documents\\pokemon.txt");
            Scanner sc = new Scanner(file);

            System.out.println("sal");
            String pattern = "#";
            while (sc.hasNextLine())
            {
                if(!(sc.nextLine().charAt(0)=='#'))
                {
                    continue;
                }
                try {
                    String fline = sc.nextLine();
                    String id = fline.toString().substring(1,fline.length()-1);
                    String sprite = id + ".png";
                    String sline = sc.nextLine();
                    String[] slist = sline.split("=");
                    String name = slist[1];
                    sc.nextLine();
                    String tline = sc.nextLine();
                    String[] tlist = tline.split("=");
                    String type1 = tlist[1];
                    String tline2 = sc.nextLine();
                    String[] tlist2 = tline2.split("=");
                    String type2 = "";
                    if(Objects.equals(tlist2[0], "Type2")) {
                         type2 = tlist2[1];
                    }
                    Pokemon pokemon = new Pokemon(name,type1,type2,sprite,1,"");
                    System.out.println(pokemon);
                    pokemonRepository.save(pokemon);
                }
                catch (Exception ignored)
                {

                }
            }
        };
    }
}
