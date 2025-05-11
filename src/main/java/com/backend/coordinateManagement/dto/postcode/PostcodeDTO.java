package com.backend.coordinateManagement.dto.postcode;

public record PostcodeDTO(
    String id, 
    String postcode,
    Double latitude,
    Double longitude
    ) {}
