package com.backend.coordinateManagement.controller;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.coordinateManagement.model.PostcodeOutcode;
import com.backend.coordinateManagement.services.IPostcodeOutcodeService;
import com.backend.coordinateManagement.util.LogUtil;

@Slf4j
@RestController
@RequestMapping("/api/v1/distance")
public class DistanceController {
    private final IPostcodeOutcodeService postcodeOutcodeService;

    public DistanceController(IPostcodeOutcodeService postcodeOutcodeService) {
        this.postcodeOutcodeService = postcodeOutcodeService;
    }
    
  @GetMapping("")
  public List<PostcodeOutcode> getPostcodeList() {
      log.info(LogUtil.ENTRY_CONTROLLER, "getPostcodeList");
      return postcodeOutcodeService.readCsv();
  }

  
}
