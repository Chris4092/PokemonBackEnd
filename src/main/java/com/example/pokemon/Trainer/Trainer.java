package com.example.pokemon.Trainer;

import com.example.pokemon.pokemon.Pokemon;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Trainer {

    @Id
    @SequenceGenerator(
            name = "trainer_sequence",
            sequenceName = "trainer_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "trainer_sequence"
    )
    private Long id;

    private String name;
    private boolean isGymLeader;
    private String type;
    @ManyToMany
    @JoinTable(
            name="trainer_pokemon",
            joinColumns = @JoinColumn(name = "trainer_id"),
            inverseJoinColumns = @JoinColumn(name = "pokemon_id")
    )
    private Set<Pokemon> pokemons = new HashSet<>();
    private String items;

    private Integer number;


    public Trainer() {
    }

    public Trainer(String name, boolean isGymLeader, String type, Set<Pokemon> pokemons, String items, Integer number) {
        this.name = name;
        this.isGymLeader = isGymLeader;
        this.type = type;
        this.pokemons = pokemons;
        this.items = items;
        this.number = number;
    }

    public Trainer(Long id, String name, boolean isGymLeader, String type, Set<Pokemon> pokemons, String items, Integer number) {
        this.id = id;
        this.name = name;
        this.isGymLeader = isGymLeader;
        this.type = type;
        this.pokemons = pokemons;
        this.items = items;
        this.number = number;
    }

    public Trainer(String name, boolean isGymLeader, String type, String items, Integer number) {
        this.name = name;
        this.isGymLeader = isGymLeader;
        this.type = type;
        this.items = items;
        this.number = number;
    }

    public Trainer(Long id, String name, boolean isGymLeader, String type, String items, Integer number) {
        this.id = id;
        this.name = name;
        this.isGymLeader = isGymLeader;
        this.type = type;
        this.items = items;
        this.number = number;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isGymLeader() {
        return isGymLeader;
    }

    public void setGymLeader(boolean gymLeader) {
        isGymLeader = gymLeader;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Set<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(Set<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    public String getItems() {
        return items;
    }

    public void setItems(String items) {
        this.items = items;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }


    public void addPokemon(Pokemon pokemon)
    {
        this.pokemons.add(pokemon);
    }

    public void deletePokemon(Pokemon pokemon)
    {
        this.pokemons.remove(pokemon);
    }
}
