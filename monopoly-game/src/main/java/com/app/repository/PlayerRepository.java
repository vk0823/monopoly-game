package com.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.model.Player;

public interface PlayerRepository extends JpaRepository<Player, Integer>{

	Optional<Player> findById(Integer playerId);

}
