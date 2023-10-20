package com.xy.pi.response;

import com.xy.pi.domain.PointsOfInterest;

public record PointsOfInterestDetailsResponse(
        Long id,
        String name,
        int xCoordinate,
        int yCoordinate,
        String createdAt,
        boolean active) {

    public PointsOfInterestDetailsResponse(PointsOfInterest pointsOfInterest) {
        this(pointsOfInterest.getId(),
                pointsOfInterest.getName(),
                pointsOfInterest.getXCoordinate(),
                pointsOfInterest.getYCoordinate(),
                pointsOfInterest.getCreatedAt().toString(),
                pointsOfInterest.isActive());
    }

}
