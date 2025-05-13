package com.backend.coordinateManagement.services.impl;

import com.backend.coordinateManagement.dto.PaginationRequestDTO;
import com.backend.coordinateManagement.dto.PaginationResponseDTO;
import com.backend.coordinateManagement.dto.distance.DistanceDTO;
import com.backend.coordinateManagement.dto.distance.DistanceRequestDTO;
import com.backend.coordinateManagement.dto.postcode.PostcodeDTO;
import com.backend.coordinateManagement.dto.postcode.PostcodeRequestDTO;
import com.backend.coordinateManagement.mapper.postcode.PostcodeMapper;
import com.backend.coordinateManagement.repository.jooq.PostcodeRepositoryJooq;
import com.backend.coordinateManagement.services.IPostcodeService;
import com.backend.coordinateManagement.util.CalculationUtil;
import com.backend.coordinateManagement.util.LogUtil;
import com.backend.coordinateManagement.util.PaginationUtil;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@AllArgsConstructor
public class PostcodeService implements IPostcodeService {
  private final PostcodeRepositoryJooq postcodeRepositoryJooq;

  @Override
  @Transactional(readOnly = true)
  public List<PostcodeDTO> getPostcodeList(
      PostcodeRequestDTO requestDTO, PaginationRequestDTO paginationRequestDTO) {
    log.info(LogUtil.ENTRY_SERVICES, "getCategoryListService");
    PaginationRequestDTO pg =
        PaginationUtil.pageSorting(paginationRequestDTO, new PostcodeMapper(), "asc");
    return postcodeRepositoryJooq.getPostcodeList(requestDTO, pg);
  }

  @Override
  @Transactional(readOnly = true)
  public PaginationResponseDTO getPostcodeListPages(
      PostcodeRequestDTO requestDTO, PaginationRequestDTO paginationRequestDTO) {
    log.info(LogUtil.ENTRY_SERVICES, "getRecipeListPagesService");
    Long total = postcodeRepositoryJooq.getPostcodeListPages(requestDTO);
    return PaginationUtil.pagination(paginationRequestDTO.size(), total);
  }

  @Override
  @Transactional(readOnly = true)
  public DistanceDTO getDistance(DistanceRequestDTO requestDTO) {
    log.info(LogUtil.ENTRY_SERVICES, "getDistanceService");
    log.info("Request DTO: {}", requestDTO);
    PostcodeDTO postcodeFrom = postcodeRepositoryJooq.getPostcode(requestDTO.postcodeFrom());
    log.info("Postcode From: {}", postcodeFrom);
    PostcodeDTO postcodeTo = postcodeRepositoryJooq.getPostcode(requestDTO.postcodeTo());
    log.info("Postcode To: {}", postcodeFrom);

    Double distanceResult =
        CalculationUtil.calculateDistance(
            postcodeFrom.latitude(),
            postcodeFrom.longitude(),
            postcodeTo.latitude(),
            postcodeTo.longitude());
    log.info("Distanace Result: {}", distanceResult);

    DistanceDTO distanceDTO =
        new DistanceDTO(requestDTO.postcodeFrom(), requestDTO.postcodeTo(), distanceResult, "KM");
    return distanceDTO;
  }
}