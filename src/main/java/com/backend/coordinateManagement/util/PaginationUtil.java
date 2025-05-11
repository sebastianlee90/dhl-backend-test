package com.backend.coordinateManagement.util;

import com.backend.coordinateManagement.dto.PaginationRequestDTO;
import com.backend.coordinateManagement.dto.PaginationResponseDTO;
import com.backend.coordinateManagement.mapper.ColumnMapper;
import java.util.Optional;

public class PaginationUtil {
  public static PaginationRequestDTO pageSorting(
      PaginationRequestDTO pageRq, ColumnMapper mapper, String defaultSortDirection) {
    String sort = mapper.getColumnName(pageRq.sort());
    Long page = pageRq.page() != null ? pageRq.page() : 1L;
    Long size = pageRq.size() != null ? pageRq.size() : 10L;
    String sortDirection =
        Optional.ofNullable(pageRq.sortDirection())
                .orElse(Optional.ofNullable(defaultSortDirection).orElse("asc"))
                .contains("desc")
            ? "desc"
            : "asc";

    return new PaginationRequestDTO(sort, sortDirection, page, size);
  }

  public static PaginationResponseDTO pagination(Long reqSize, Long total) {
    Long size = reqSize != null ? reqSize : 10L;
    Long totalPages = total / size;
    if (total % size > 0) {
      totalPages++;
    }
    return new PaginationResponseDTO(totalPages, total, size);
  }
}
