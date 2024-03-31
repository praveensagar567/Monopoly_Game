package com.Business.service;

import com.Business.dto.PlaceDTO;

public interface PlaceService {
    Iterable<PlaceDTO> getAllPlaces();
    PlaceDTO getPlaceInfo(Long placeId);
    // Add other methods as needed
}
