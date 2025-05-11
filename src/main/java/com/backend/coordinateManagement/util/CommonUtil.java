package com.backend.coordinateManagement.util;

public class CommonUtil {
  public static <T> Boolean isNotEmpty(T value) {
    if (value != null) {
      return true;
    }

    // Check for String
    if (value instanceof String) {
      return !((String) value).isBlank();
    }
    return false;
  }
}
