package com.Business.service;

import com.Business.dto.GameDTO;
import com.Business.entity.Game;
import com.Business.repository.GameRepository;
import org.springframework.stereotype.Service;

@Service
public class GameServiceImpl implements GameService {

    private final GameRepository gameRepository;

    public GameServiceImpl(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Override
    public GameDTO createGame() {
        Game game = new Game();
        gameRepository.save(game);

        // Create a GameDTO object and set its ID
        GameDTO gameDTO = new GameDTO();
        gameDTO.setId(game.getId());

        return gameDTO;
    }

    @Override
    public void joinGame(Long gameId, String playerName) {
        // Implement logic to join game
    }

    @Override
    public String rollDice(Long gameId, Long playerId) {
        // Implement logic for dice rolling
        return "Dice rolled successfully.";
    }

    @Override
    public void movePlayer(Long gameId, Long playerId, int steps) {
        // Implement logic to move the player
    }

    // Add other methods as needed
}
