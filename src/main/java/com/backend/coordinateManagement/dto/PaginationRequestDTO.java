package com.backend.coordinateManagement.dto;

public record PaginationRequestDTO(String sort, String sortDirection, Long page, Long size) {}
