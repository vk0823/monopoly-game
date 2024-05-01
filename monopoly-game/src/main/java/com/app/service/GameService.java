package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.Game;
import com.app.model.Place;
import com.app.model.Player;
import com.app.repository.GameRepository;
import com.app.repository.PlaceRepository;
import com.app.repository.PlayerRepository;

@Service
public class GameService {

	@Autowired
    private GameRepository gameRepository;

    @Autowired
    private PlayerRepository playerRepository;
    
    @Autowired
    private PlaceRepository placeRepository;
    
	@Autowired
    private PlayerService playerService;

    @Autowired
    private PlaceService placeService;
	
	public void createNewGame() {
		Game game=new Game();
		game.setGameStatus("New");
		gameRepository.save(game);
	}
	
	 public String rollDieAndTakeAction(int playerId) {
	        // Roll the die (assuming it generates a random number)
	        int dieResult = rollDie();

	        // Retrieve player and check if exists
	        Player player = playerRepository.findById(playerId).orElse(null);
	        if (player == null) {
	            return "Player not found!";
	        }

	        // Retrieve a random unclaimed place
	        Place place = placeRepository.findRandomUnclaimedPlace();

	        // Check if a place is found
	        if (place == null) {
	            return "No unclaimed places found.";
	        }

	        // Logic to handle the die result and buying a place
	        String actionResult = handleDieResult(player, dieResult, place);

	        return actionResult;
	    }

	    private int rollDie() {
	        // Logic to generate a random number between 1 and 12
	        return (int) (Math.random() * 12) + 1;
	    }

	    private String handleDieResult(Player player, int dieResult, Place place) {
	        // Check if the place is unclaimed
	        if (!place.isClaimed()) {
	            // Deduct the buy price from player's cash
	            int buyPrice = place.getBuyPrice();
	            if (player.getCash() >= buyPrice) {
	                player.setCash(player.getCash() - buyPrice);
	                place.setClaimed(true);
	                placeRepository.save(place);
	                playerRepository.save(player);
	                return "Die rolled " + dieResult + " and landed on Place " + place.getName() + ". Unclaimed place and bought for $" + buyPrice + ". Remaining balance is $" + player.getCash() + ".";
	            } else {
	                return "Not enough cash to buy the place.";
	            }
	        } else {
	            // Logic for other actions if the place is claimed
	            // For simplicity, let's assume some other action
	            return "Die rolled " + dieResult + " and landed on Place " + place.getName() + ". Place is already claimed.";
	        }
	    }
	    
	    
}
 

