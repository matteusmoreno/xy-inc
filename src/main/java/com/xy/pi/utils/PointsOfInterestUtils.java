package com.xy.pi.utils;

import com.xy.pi.domain.PointsOfInterest;
import com.xy.pi.exception.NegativeCoordinateException;
import com.xy.pi.request.PointsOfInterestCreateRequest;
import com.xy.pi.request.PointsOfInterestFindByProximityRequest;
import com.xy.pi.request.PointsOfInterestUpdateRequest;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Objects;

@Component
public class PointsOfInterestUtils {

    public void setCreateAttributes(PointsOfInterest pointsOfInterest, PointsOfInterestCreateRequest request) {
        pointsOfInterest.setName(request.name());
        pointsOfInterest.setXCoordinate(request.xCoordinate());
        pointsOfInterest.setYCoordinate(request.yCoordinate());
        pointsOfInterest.setCreatedAt(LocalDateTime.now());
        pointsOfInterest.setActive(true);
    }

    public void setUpdateAttributes(PointsOfInterest pointsOfInterest, PointsOfInterestUpdateRequest request) {
        if (!Objects.equals(request.name(), pointsOfInterest.getName())) pointsOfInterest.setName(request.name());
        if (request.xCoordinate() != pointsOfInterest.getXCoordinate())
            pointsOfInterest.setXCoordinate(request.xCoordinate());
        if (request.yCoordinate() != pointsOfInterest.getYCoordinate())
            pointsOfInterest.setYCoordinate(request.yCoordinate());

    }
}
