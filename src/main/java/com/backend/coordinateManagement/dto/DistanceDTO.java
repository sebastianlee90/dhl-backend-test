package com.backend.coordinateManagement.dto;

public record DistanceDTO(
String Id, 
String postcode,
String latitude,
String longitude,
String distance,
String distanceUom) {}
