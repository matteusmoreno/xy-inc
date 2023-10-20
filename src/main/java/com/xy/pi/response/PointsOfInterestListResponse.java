package com.xy.pi.response;

import com.xy.pi.domain.PointsOfInterest;

public record PointsOfInterestListResponse(
        String name,
        int xCoordinate,
        int yCoordinate) {

    public PointsOfInterestListResponse(PointsOfInterest pointsOfInterest) {
        this(pointsOfInterest.getName(), pointsOfInterest.getXCoordinate(), pointsOfInterest.getYCoordinate());
    }
}
