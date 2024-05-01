package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.Player;
import com.app.service.GameService;

@RestController
@RequestMapping("/game")
public class GameController {

	@Autowired
    private GameService gameService;

    @PostMapping("/create")
    public ResponseEntity<String> createGame() {
        gameService.createNewGame();
        return ResponseEntity.ok("New game created successfully");
    }
    
    @PostMapping("/{playerId}")
    public ResponseEntity<String> rollDieAndTakeAction(@PathVariable int playerId) {
        String result = gameService.rollDieAndTakeAction(playerId);
        return ResponseEntity.ok(result);
    }
    
    
  
    

}

	

