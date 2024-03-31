package com.Business.controller;

import com.Business.dto.PlaceDTO;
import com.Business.service.PlaceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/place")
public class PlaceController {

    private final PlaceService placeService;

    public PlaceController(PlaceService placeService) {
        this.placeService = placeService;
    }

    @GetMapping("/list")
    public ResponseEntity<Iterable<PlaceDTO>> getAllPlaces() {
        Iterable<PlaceDTO> places = placeService.getAllPlaces();
        return ResponseEntity.ok(places);
    }

    @GetMapping("/info/{placeId}")
    public ResponseEntity<PlaceDTO> getPlaceInfo(@PathVariable Long placeId) {
        PlaceDTO placeDTO = placeService.getPlaceInfo(placeId);
        return ResponseEntity.ok(placeDTO);
    }
}
