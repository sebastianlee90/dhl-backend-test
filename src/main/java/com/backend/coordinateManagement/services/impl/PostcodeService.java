package com.backend.coordinateManagement.services.impl;

import com.backend.coordinateManagement.dto.PostcodeDTO;
import com.backend.coordinateManagement.repository.jooq.PostcodeRepositoryJooq;
import com.backend.coordinateManagement.services.IPostcodeService;
import com.backend.coordinateManagement.util.LogUtil;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class PostcodeService implements IPostcodeService {
    private final PostcodeRepositoryJooq postcodeRepositoryJooq;

    public List<PostcodeDTO> getPostcodeList() {
        log.info(LogUtil.ENTRY_SERVICES, "getCategoryList");
        return postcodeRepositoryJooq.getPostcodeList();
    }
}