package com.backend.coordinateManagement.dto.distance;

public record DistanceDTO(
    String postcodeFrom, String postcodeTo, Double distance, String distanceUom) {}
