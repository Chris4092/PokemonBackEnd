package com.example.pokemon.move;

import com.example.pokemon.pokemon.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/move")
public class MoveController {

    private final MoveService moveService;
    private final PokemonService pokemonService;

    @Autowired
    public MoveController(MoveService moveService, PokemonService pokemonService)
    {
        this.moveService = moveService;
        this.pokemonService = pokemonService;
    }

    @GetMapping
    public List<Move> getAllMoves()
    {
        return moveService.getAllMoves();
    }

    @PostMapping
    public void addNewMove(@RequestBody Move move) {
        moveService.addNewMove(move);
    }

    @DeleteMapping(path = "{moveId}")
    public void deleteMove(@PathVariable("moveId") Long moveId)
    {
        Move move = moveService.getMoveById(moveId);
        pokemonService.deleteMoveFromPokemon(move);
        moveService.deleteMove(moveId);
    }
}
