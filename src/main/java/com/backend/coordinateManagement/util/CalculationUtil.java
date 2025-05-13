package com.backend.coordinateManagement.util;

public class CalculationUtil {
  public static Double calculateDistance(Double lat1, Double long1, Double lat2, Double long2) {
    final Double NAUTICAL_MILES = 1.1515;
    final Double KM_IN_MILES = 1.609344;

    Double theta = long1 - long2;
    Double dist =
        Math.acos(
            Math.sin(Math.toRadians(lat1)) * Math.sin(Math.toRadians(lat2))
                + Math.cos(Math.toRadians(lat1))
                    * Math.cos(Math.toRadians(lat2))
                    * Math.cos(Math.toRadians(theta)));

    dist = Math.toDegrees(dist);
    dist = dist * 60;
    return dist * NAUTICAL_MILES * KM_IN_MILES;
  }
}
