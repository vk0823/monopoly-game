package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.model.Place;

public interface PlaceRepository extends JpaRepository<Place, Integer>{
    @Query("SELECT p FROM Place p WHERE p.claimed = false ORDER BY RAND() LIMIT 1")

	Place findRandomUnclaimedPlace();

}
