package com.example.pokemon.DTO;

import java.util.List;

public class PokemonMoveDTO {
    Integer id;
    List<Integer> idList;

    Integer level;

    public PokemonMoveDTO(Integer id, List<Integer> idList, Integer level) {
        this.id = id;
        this.idList = idList;
        this.level = level;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public List<Integer> getIdList() {
        return idList;
    }

    public void setIdList(List<Integer> idList) {
        this.idList = idList;
    }
}
