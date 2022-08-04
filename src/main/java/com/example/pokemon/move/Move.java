package com.example.pokemon.move;

import com.example.pokemon.pokemon.Pokemon;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Move {


    @Id
    @SequenceGenerator(
            name = "move_sequence",
            sequenceName = "move_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "move_sequence"
    )
    private Long id;
    private String name;
    private int power;
    private String damageType;
    private String elementalType;
    private String accuracy;



    @JsonIgnore
    @ManyToMany(mappedBy = "moves")
    private Set<Pokemon> pokemons = new HashSet<>();


    public Move(Long id, String name, int power, String damageType, String elementalType, String accuracy, Set<Pokemon> pokemons) {
        this.id = id;
        this.name = name;
        this.power = power;
        this.damageType = damageType;
        this.elementalType = elementalType;
        this.accuracy = accuracy;
        this.pokemons = pokemons;
    }

    public Move(String name, int power, String damageType, String elementalType, String accuracy, Set<Pokemon> pokemons) {

        this.name = name;
        this.power = power;
        this.damageType = damageType;
        this.elementalType = elementalType;
        this.accuracy = accuracy;
        this.pokemons = pokemons;
    }

    public Move(String name, int power, String damageType, String elementalType, String accuracy) {
        this.name = name;
        this.power = power;
        this.damageType = damageType;
        this.elementalType = elementalType;
        this.accuracy = accuracy;
    }

    public Move(Long id, String name, int power, String damageType, String elementalType, String accuracy) {
        this.id = id;
        this.name = name;
        this.power = power;
        this.damageType = damageType;
        this.elementalType = elementalType;
        this.accuracy = accuracy;
    }

    public Move() {
    }

    @Override
    public String toString() {
        return "Move{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", power=" + power +
                ", damageType='" + damageType + '\'' +
                ", elementalType='" + elementalType + '\'' +
                ", accuracy='" + accuracy + '\'' +
                '}';
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

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public String getDamageType() {
        return damageType;
    }

    public void setDamageType(String damageType) {
        this.damageType = damageType;
    }

    public String getElementalType() {
        return elementalType;
    }

    public void setElementalType(String elementalType) {
        this.elementalType = elementalType;
    }

    public String getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(String additionalEffects) {
        this.accuracy = additionalEffects;
    }

    public Set<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(Set<Pokemon> pokemons) {
        this.pokemons = pokemons;
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
