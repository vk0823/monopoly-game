package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.Player;
import com.app.repository.PlayerRepository;

@Service
public class PlayerService {

	@Autowired
    private PlayerRepository playerRepository;

	public Player createPlayer(Player player) {
        return playerRepository.save(player);
    }

	public Player getPlayerById(int playerId) {
		return playerRepository.findById(playerId).orElseThrow(()->new RuntimeException("player not found : "+playerId));
		
	}


}
