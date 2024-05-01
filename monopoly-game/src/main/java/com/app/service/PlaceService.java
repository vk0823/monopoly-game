package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.Place;
import com.app.repository.PlaceRepository;

@Service
public class PlaceService {

    @Autowired
    private PlaceRepository placeRepository;

    public Place createPlace(Place place) {
        return placeRepository.save(place);
    }

    public Place getPlaceById(int placeId) {
        return placeRepository.findById(placeId)
                .orElseThrow(() -> new RuntimeException("Place not found with ID: " + placeId));
    }

}
