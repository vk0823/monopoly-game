package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.Place;
import com.app.service.PlaceService;

@RestController
@RequestMapping("/places")
public class PlaceController {

    @Autowired
    private PlaceService placeService;

    @PostMapping
    public ResponseEntity<Place> createPlace(@RequestBody Place place) {
        Place createdPlace = placeService.createPlace(place);
        return ResponseEntity.ok(createdPlace);
    }

    @GetMapping("/{placeId}")
    public ResponseEntity<Place> getPlaceById(@PathVariable int placeId) {
        Place place = placeService.getPlaceById(placeId);
        return ResponseEntity.ok(place);
    }

}
