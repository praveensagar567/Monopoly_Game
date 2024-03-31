package com.Business.controller;

import com.Business.dto.GameDTO;
import com.Business.service.GameService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/game")
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping("/create")
    public ResponseEntity<GameDTO> createGame() {
        GameDTO gameDTO = gameService.createGame();
        return ResponseEntity.ok(gameDTO);
    }

    @PostMapping("/join/{gameId}/{playerName}")
    public ResponseEntity<String> joinGame(@PathVariable Long gameId, @PathVariable String playerName) {
        gameService.joinGame(gameId, playerName);
        return ResponseEntity.ok(playerName + " joined the game.");
    }

    @PostMapping("/roll-dice/{gameId}/{playerId}")
    public ResponseEntity<String> rollDice(@PathVariable Long gameId, @PathVariable Long playerId) {
        String result = gameService.rollDice(gameId, playerId);
        return ResponseEntity.ok(result);
    }
}
