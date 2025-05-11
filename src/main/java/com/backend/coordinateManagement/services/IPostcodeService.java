package com.backend.coordinateManagement.services;

import java.util.List;

import com.backend.coordinateManagement.dto.PostcodeDTO;

public interface IPostcodeService {
    
    List<PostcodeDTO> getPostcodeList();
}
