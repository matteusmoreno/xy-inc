package com.xy.pi.verifier;

import com.xy.pi.exception.NegativeCoordinateException;
import com.xy.pi.request.PointsOfInterestCreateRequest;
import com.xy.pi.request.PointsOfInterestFindByProximityRequest;
import com.xy.pi.request.PointsOfInterestUpdateRequest;
import org.springframework.stereotype.Component;

@Component
public class NegativeCoordinateVerifier {


    public void VerifyIfThereIsNegativeCoordinateOnCreate(PointsOfInterestCreateRequest request) {
        if (request.xCoordinate() < 0 || request.yCoordinate() < 0) {
            throw new NegativeCoordinateException();
        }
    }

    public void VerifyIfThereIsNegativeCoordinateOnUpdate(PointsOfInterestUpdateRequest request) {
        if (request.xCoordinate() < 0 || request.yCoordinate() < 0) {
            throw new NegativeCoordinateException();
        }
    }

    public void VerifyIfThereIsNegativeCoordinateOnFindByProximities(PointsOfInterestFindByProximityRequest request) {
        if (request.xCoordinate() < 0 || request.yCoordinate() < 0) {
            throw new NegativeCoordinateException();
        }
    }
}
