package com.Business.controller;

import com.Business.dto.PlayerDTO;
import com.Business.service.PlayerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/player")
public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createPlayer(@RequestParam String playerName) {
        Long playerId = playerService.createPlayer(playerName);
        return ResponseEntity.ok("Player created with ID: " + playerId);
    }

    @GetMapping("/info/{playerId}")
    public ResponseEntity<PlayerDTO> getPlayerInfo(@PathVariable Long playerId) {
        PlayerDTO playerDTO = playerService.getPlayerInfo(playerId);
        return ResponseEntity.ok(playerDTO);
    }
}
