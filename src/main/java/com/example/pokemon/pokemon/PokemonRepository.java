package com.example.pokemon.pokemon;

import com.example.pokemon.move.Move;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.OrderBy;
import java.util.List;
import java.util.Set;

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon, Long> {

    @Query("SELECT distinct p from Pokemon p JOIN p.moves move")
    List<Pokemon> getPokemonWithMoves();

    @Query("SELECT p from Pokemon p where p not in(SELECT distinct p from Pokemon p JOIN p.moves move)")
    List<Pokemon> getPokemonWithoutMoves();
}
