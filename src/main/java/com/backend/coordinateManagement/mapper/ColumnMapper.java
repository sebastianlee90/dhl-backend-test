package com.backend.coordinateManagement.mapper;

import java.util.LinkedHashMap;
import java.util.Map;

public class ColumnMapper {
  protected Map<String, String> COLUMN_MAP = new LinkedHashMap<>();

  public String getColumnName(String variableName) {
    if (variableName == null || variableName.isEmpty()) {
      return COLUMN_MAP.values().iterator().next();
    }

    String variableNameStr = variableName;
    String result = COLUMN_MAP.get(variableNameStr);
    if (result == null) {
      return COLUMN_MAP.values().iterator().next();
    }
    return result;
  }
}
