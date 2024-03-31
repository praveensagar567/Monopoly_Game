package com.Business.service;

import com.Business.dto.GameDTO;

public interface GameService {
    GameDTO createGame();
    void joinGame(Long gameId, String playerName);
    String rollDice(Long gameId, Long playerId);
    void movePlayer(Long gameId, Long playerId, int steps);
    // Add other methods as needed
}
