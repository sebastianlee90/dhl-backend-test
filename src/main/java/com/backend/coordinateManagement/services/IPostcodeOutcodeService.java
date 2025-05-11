package com.backend.coordinateManagement.services;

import java.util.List;

import com.backend.coordinateManagement.model.PostcodeOutcode;

public interface IPostcodeOutcodeService {
    
    List<PostcodeOutcode> readCsv();
}
