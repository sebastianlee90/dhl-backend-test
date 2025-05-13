package com.backend.coordinateManagement.mapper.postcode;

import com.backend.coordinateManagement.mapper.ColumnMapper;

public class PostcodeMapper extends ColumnMapper {
  public PostcodeMapper() {
    COLUMN_MAP.put("id", "id");
    COLUMN_MAP.put("postcode", "postcode");
    COLUMN_MAP.put("latitude", "latitude");
    COLUMN_MAP.put("longitude", "longitude");
  }
}
