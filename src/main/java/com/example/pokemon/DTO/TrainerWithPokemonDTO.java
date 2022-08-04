package com.example.pokemon.DTO;

import java.util.List;

public class TrainerWithPokemonDTO {
    private String name;
    private Integer number;
    private List<Integer> idList;


    public TrainerWithPokemonDTO(String name, Integer number, List<Integer> idList) {
        this.name = name;
        this.number = number;
        this.idList = idList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public List<Integer> getIdList() {
        return idList;
    }

    public void setIdList(List<Integer> idList) {
        this.idList = idList;
    }
}
