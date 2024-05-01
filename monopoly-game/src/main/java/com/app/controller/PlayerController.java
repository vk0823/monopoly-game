package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.Player;
import com.app.service.PlayerService;

@RestController
@RequestMapping("/player")
public class PlayerController {

	 @Autowired
	    private PlayerService playerService;

	 @PostMapping
	    public ResponseEntity<Player> createPlayer(@RequestBody Player player) {
	        Player createdPlayer = playerService.createPlayer(player);
	        return ResponseEntity.ok(createdPlayer);
	    }

	    @GetMapping("/{playerId}")
	   public ResponseEntity<Player> getPlayerById(@PathVariable int playerId){
	    	Player player=playerService.getPlayerById(playerId);
	    	return ResponseEntity.ok(player);
	    }
}
