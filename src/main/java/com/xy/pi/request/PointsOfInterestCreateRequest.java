package com.xy.pi.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PointsOfInterestCreateRequest(
        @NotBlank(message = "Name is mandatory")
        String name,
        @NotNull(message = "X coordinate is mandatory")
        int xCoordinate,
        @NotNull(message = "Y coordinate is mandatory")
        int yCoordinate) {
}
