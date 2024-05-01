package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.model.Game;
import com.app.model.Place;

public interface GameRepository extends JpaRepository<Game, Integer> {
}
