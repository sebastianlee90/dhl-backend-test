package com.backend.coordinateManagement.controller;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.backend.coordinateManagement.dto.PaginationRequestDTO;
import com.backend.coordinateManagement.dto.PaginationResponseDTO;
import com.backend.coordinateManagement.dto.distance.DistanceDTO;
import com.backend.coordinateManagement.dto.distance.DistanceRequestDTO;
import com.backend.coordinateManagement.dto.postcode.PostcodeDTO;
import com.backend.coordinateManagement.dto.postcode.PostcodeRequestDTO;
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
  public List<PostcodeDTO> getPostcodeList(
    @RequestParam(required = false) String postcode,
    @RequestParam(required = false) String sort,
    @RequestParam(required = false) String sortDirection,
    @RequestParam(required = false) Long page,
    @RequestParam(required = false) Long size
  ) {
      log.info(LogUtil.ENTRY_CONTROLLER, "getPostcodeListController");
      PostcodeRequestDTO requestDTO = new PostcodeRequestDTO(postcode);
      PaginationRequestDTO paginationRequestDTO =
        new PaginationRequestDTO(sort, sortDirection, page, size);

      Long startTime = System.currentTimeMillis();
      List<PostcodeDTO> result = postcodeService.getPostcodeList(requestDTO, paginationRequestDTO);
      Long endTime = System.currentTimeMillis();
      log.info("API Query executed in {} ms", (endTime - startTime));
      return result;
  }

  @GetMapping("/page")
  public PaginationResponseDTO getPostcodeListPages(
    @RequestParam(required = false) String postcode,
    @RequestParam(required = false) Long size
  ) {
      log.info(LogUtil.ENTRY_CONTROLLER, "getPostcodeListPagesController");
      PostcodeRequestDTO requestDTO = new PostcodeRequestDTO(postcode);
      PaginationRequestDTO paginationRequestDTO = new PaginationRequestDTO(null, null, null, size);

      Long startTime = System.currentTimeMillis();
      PaginationResponseDTO result = postcodeService.getPostcodeListPages(requestDTO, paginationRequestDTO);
      Long endTime = System.currentTimeMillis();
      log.info("API Query executed in {} ms", (endTime - startTime));

      return result;
  }

  @GetMapping("/calculate_distance")
  public DistanceDTO getDistance(
    @RequestParam(required = false) String postcodeFrom,
    @RequestParam(required = false) String postcodeTo
  ) {
      log.info(LogUtil.ENTRY_CONTROLLER, "getDistanceController");
      DistanceRequestDTO requestDTO = new DistanceRequestDTO(postcodeFrom, postcodeTo);

      Long startTime = System.currentTimeMillis();
      DistanceDTO result = postcodeService.getDistance(requestDTO);
      Long endTime = System.currentTimeMillis();
      log.info("API Query executed in {} ms", (endTime - startTime));

      return result;
  }
}
