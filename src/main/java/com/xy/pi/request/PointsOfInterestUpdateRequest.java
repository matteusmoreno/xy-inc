package com.xy.pi.request;

import jakarta.validation.constraints.NotNull;

public record PointsOfInterestUpdateRequest(
        @NotNull(message = "id is required")
        Long id,
        String name,
        int xCoordinate,
        int yCoordinate) {
}
