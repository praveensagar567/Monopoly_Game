package com.Business.service;

import com.Business.dto.PlaceDTO;
import com.Business.entity.Place;
import com.Business.repository.PlaceRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlaceServiceImpl implements PlaceService {

    private final PlaceRepository placeRepository;

    public PlaceServiceImpl(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    @Override
    public Iterable<PlaceDTO> getAllPlaces() {
        List<PlaceDTO> places = new ArrayList<>();
        placeRepository.findAll().forEach(place -> {
            PlaceDTO placeDTO = new PlaceDTO();
            placeDTO.setId(place.getId());
            placeDTO.setName(place.getName());
            placeDTO.setBuyPrice(place.getBuyPrice());
            placeDTO.setRent(place.getRent());
            places.add(placeDTO);
        });
        return places;
    }

    @Override
    public PlaceDTO getPlaceInfo(Long placeId) {
        Place place = placeRepository.findById(placeId).orElseThrow(() -> new IllegalArgumentException("Place not found"));
        PlaceDTO placeDTO = new PlaceDTO();
        placeDTO.setId(place.getId());
        placeDTO.setName(place.getName());
        placeDTO.setBuyPrice(place.getBuyPrice());
        placeDTO.setRent(place.getRent());
        return placeDTO;
    }

    // Add other methods as needed
}
