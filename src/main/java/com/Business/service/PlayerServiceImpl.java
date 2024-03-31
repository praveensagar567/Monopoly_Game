package com.Business.service;

import com.Business.dto.PlayerDTO;
import com.Business.entity.Player;
import com.Business.repository.PlayerRepository;
import org.springframework.stereotype.Service;

@Service
public class PlayerServiceImpl implements PlayerService {

    private final PlayerRepository playerRepository;

    public PlayerServiceImpl(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public Long createPlayer(String playerName) {
        Player player = new Player();
        player.setName(playerName);
        player.setCash(1000);
        playerRepository.save(player);
        return player.getId();
    }

    @Override
    public PlayerDTO getPlayerInfo(Long playerId) {
        Player player = playerRepository.findById(playerId).orElseThrow(() -> new IllegalArgumentException("Player not found"));
        PlayerDTO playerDTO = new PlayerDTO();
        playerDTO.setId(player.getId());
        playerDTO.setName(player.getName());
        playerDTO.setCash(player.getCash());
        return playerDTO;
    }

    // Add other methods as needed
}
