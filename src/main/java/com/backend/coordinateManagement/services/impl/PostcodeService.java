package com.backend.coordinateManagement.services.impl;

import com.backend.coordinateManagement.dto.PaginationRequestDTO;
import com.backend.coordinateManagement.dto.PaginationResponseDTO;
import com.backend.coordinateManagement.dto.postcode.PostcodeDTO;
import com.backend.coordinateManagement.dto.postcode.PostcodeRequestDTO;
import com.backend.coordinateManagement.mapper.postcode.PostcodeMapper;
import com.backend.coordinateManagement.repository.jooq.PostcodeRepositoryJooq;
import com.backend.coordinateManagement.services.IPostcodeService;
import com.backend.coordinateManagement.util.LogUtil;
import com.backend.coordinateManagement.util.PaginationUtil;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class PostcodeService implements IPostcodeService {
    private final PostcodeRepositoryJooq postcodeRepositoryJooq;

    @Override
    public List<PostcodeDTO> getPostcodeList(
        PostcodeRequestDTO requestDTO, PaginationRequestDTO paginationRequestDTO) {
        log.info(LogUtil.ENTRY_SERVICES, "getCategoryList");
        PaginationRequestDTO pg =
            PaginationUtil.pageSorting(paginationRequestDTO, new PostcodeMapper(), "asc");
        return postcodeRepositoryJooq.getPostcodeList(requestDTO, pg);
    }

    @Override
    public PaginationResponseDTO getPostcodeListPages(
        PostcodeRequestDTO requestDTO, PaginationRequestDTO paginationRequestDTO) {
        log.info(LogUtil.ENTRY_SERVICES, "getRecipeListPages");
        Long total = postcodeRepositoryJooq.getPostcodeListPages(requestDTO);
        return PaginationUtil.pagination(paginationRequestDTO.size(), total);
    }
}