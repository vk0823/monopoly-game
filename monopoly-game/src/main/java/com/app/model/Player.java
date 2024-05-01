package com.app.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Player {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
    
	private String name;
    
	private int cash;
	
	@ManyToOne
	@JoinColumn(name="game_id")
	private Game game;
	
	public Player() {
	}
	
	public Player(String name, int cash) {
        this.name = name;
        this.cash = cash;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCash() {
		return cash;
	}

	public void setCash(int cash) {
		this.cash = cash;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}
	

	
}
