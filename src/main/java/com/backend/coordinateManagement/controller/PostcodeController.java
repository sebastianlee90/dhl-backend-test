package com.backend.coordinateManagement.controller;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.coordinateManagement.dto.PostcodeDTO;
import com.backend.coordinateManagement.services.IPostcodeService;
import com.backend.coordinateManagement.util.LogUtil;

@Slf4j
@RestController
@RequestMapping("/api/v1/postcode")
public class PostcodeController {
    private final IPostcodeService postcodeService;

    public PostcodeController(IPostcodeService postcodeService) {
        this.postcodeService = postcodeService;
    }
    
  @GetMapping("")
  public List<PostcodeDTO> getPostcodeList() {
      log.info(LogUtil.ENTRY_CONTROLLER, "getPostcodeList");
      return postcodeService.getPostcodeList();
  }

  
}
