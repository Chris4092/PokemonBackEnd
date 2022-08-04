package com.example.pokemon.move;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

@Configuration
public class MoveConfig {
    @Bean
    CommandLineRunner commandLineRunnerMove(MoveRepository moveRepository){
        return args -> {
//            Move toxic = new Move(1L, "Pound", 40, "physical", "normal", "100%");
//            Move quickAttack = new Move("Karate Chop", 50, "physical", "fighting", "100%");
//            Move firePunch = new Move("Fire Punch", 75, "physical", "fire", "100%");
//            Move icePunch = new Move("Ice Punch", 75, "physical", "ice", "100%");
//            Move thunderPunch = new Move("Electric Punch", 75, "physical", "electric", "100%");
//            Move gust = new Move("Gust", 40, "special", "flying", "100%");
//            Move sandAttack = new Move("Sand Attack", 0, "status", "ground", "100%");
//            Move pinMissle = new Move("Pin Missle", 25, "physical", "bug", "95%");
//
//
//            moveRepository.saveAll(List.of(toxic, quickAttack, firePunch, icePunch, thunderPunch, gust, sandAttack, pinMissle));

            File file = new File("C:\\Users\\chris\\Documents\\moves.txt");
            Scanner sc = new Scanner(file);

            while (sc.hasNextLine())
            {
                try {
                    String line = sc.nextLine();
                    String[] list = line.split("\\t");
                    int power;
                    list[5] = list[5].replace("*", "");
                    if (list[2].contains("*")) {
                        list[2] = list[2].replace("*", "");
                    }
                    if (list[2].equals("—")) {
                        list[2] = "0";
                    }
                    Move move = new Move(list[1], Integer.parseInt(list[5]), list[3], list[2], list[6]);
                    moveRepository.save(move);
                }
                catch (Exception ignored)
                {

                }
            }
        };


    }
}
