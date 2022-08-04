package com.example.pokemon.move;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MoveRepository extends JpaRepository<Move, Long> {

    @Query("SELECT m FROM Move m WHERE m.name = ?1")
    Optional<Move> findMoveByName(String name);
}
