package com.xy.pi.request;

import jakarta.validation.constraints.NotNull;

public record PointsOfInterestFindByProximityRequest(
        @NotNull(message = "xCoordinate is required")
        int xCoordinate,
        @NotNull(message = "yCoordinate is required")
        int yCoordinate,
        @NotNull(message = "maxDistance is required")
        int maxDistance) {

}
