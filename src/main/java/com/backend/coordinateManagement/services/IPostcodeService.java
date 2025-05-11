package com.backend.coordinateManagement.services;

import java.util.List;

import com.backend.coordinateManagement.dto.PaginationRequestDTO;
import com.backend.coordinateManagement.dto.PaginationResponseDTO;
import com.backend.coordinateManagement.dto.distance.DistanceDTO;
import com.backend.coordinateManagement.dto.distance.DistanceRequestDTO;
import com.backend.coordinateManagement.dto.postcode.PostcodeDTO;
import com.backend.coordinateManagement.dto.postcode.PostcodeRequestDTO;

public interface IPostcodeService {
    
    List<PostcodeDTO> getPostcodeList(
        PostcodeRequestDTO requestDTO, PaginationRequestDTO paginationRequestDTO);
    
    PaginationResponseDTO getPostcodeListPages(
      PostcodeRequestDTO requestDTO, PaginationRequestDTO paginationRequestDTO);

    DistanceDTO getDistance(
        DistanceRequestDTO requestDTO);
}
