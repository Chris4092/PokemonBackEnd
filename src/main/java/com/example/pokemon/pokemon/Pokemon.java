package com.example.pokemon.pokemon;

import com.example.pokemon.Trainer.Trainer;
import com.example.pokemon.move.Move;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Pokemon {
    @Id
    @SequenceGenerator(
            name = "pokemon_sequence",
            sequenceName = "pokemon_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "pokemon_sequence"
    )
    private Long id;

    @ManyToMany
    @JoinTable(
            name="pokemon_moves",
            joinColumns = @JoinColumn(name = "pokemon_id"),
            inverseJoinColumns = @JoinColumn(name = "move_id")
    )
    private Set<Move> moves = new HashSet<>();

    @JsonIgnore
    @ManyToMany(mappedBy = "pokemons")
    private Set<Trainer> trainers = new HashSet<>();
    private String name;
    private String type1;


    private String type2;

    private String imageSprite;

    private Integer level;
    private String item;

    public Pokemon() {
    }

    public Pokemon(Long id, Set<Move> moves, String name, String type1, String type2, String imageSprite, Integer level, String item) {
        this.id = id;
        this.moves = moves;
        this.name = name;
        this.type1 = type1;
        this.type2 = type2;
        this.imageSprite = imageSprite;
        this.level = level;
        this.item = item;
    }

    public Pokemon(Set<Move> moves, String name, String type1, String type2, String imageSprite, Integer level, String item) {
        this.moves = moves;
        this.name = name;
        this.type1 = type1;
        this.type2 = type2;
        this.imageSprite = imageSprite;
        this.level = level;
        this.item = item;
    }

    public Pokemon(Long id, String name, String type1, String type2, String imageSprite, Integer level, String item) {
        this.id = id;
        this.name = name;
        this.type1 = type1;
        this.type2 = type2;
        this.imageSprite = imageSprite;
        this.level = level;
        this.item = item;
    }

    public Pokemon(String name, String type1, String type2, String imageSprite, Integer level, String item) {
        this.name = name;
        this.type1 = type1;
        this.type2 = type2;
        this.imageSprite = imageSprite;
        this.level = level;
        this.item = item;
    }

    public Pokemon(Long id, Set<Move> moves, Set<Trainer> trainers, String name, String type1, String type2, String imageSprite, Integer level, String item) {
        this.id = id;
        this.moves = moves;
        this.trainers = trainers;
        this.name = name;
        this.type1 = type1;
        this.type2 = type2;
        this.imageSprite = imageSprite;
        this.level = level;
        this.item = item;
    }

    public Pokemon(Set<Move> moves, Set<Trainer> trainers, String name, String type1, String type2, String imageSprite, Integer level, String item) {
        this.moves = moves;
        this.trainers = trainers;
        this.name = name;
        this.type1 = type1;
        this.type2 = type2;
        this.imageSprite = imageSprite;
        this.level = level;
        this.item = item;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Move> getMoves() {
        return moves;
    }

    public void setMoves(Set<Move> moves) {
        this.moves = moves;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType1() {
        return type1;
    }

    public void setType1(String type1) {
        this.type1 = type1;
    }

    public String getType2() {
        return type2;
    }

    public void setType2(String type2) {
        this.type2 = type2;
    }

    public String getImageSprite() {
        return imageSprite;
    }

    public void setImageSprite(String imageSprite) {
        this.imageSprite = imageSprite;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Set<Trainer> getTrainers() {
        return trainers;
    }

    public void setTrainers(Set<Trainer> trainers) {
        this.trainers = trainers;
    }

    public void addTrainer(Trainer trainer)
    {
        this.trainers.add(trainer);
    }


    public void addMove(Move move)
    {
        this.moves.add(move);
    }

    public void deleteMove(Move move)
    {
        this.moves.remove(move);
    }

    public void deleteTrainer(Trainer trainer)
    {
        this.trainers.remove(trainer);
    }
}
