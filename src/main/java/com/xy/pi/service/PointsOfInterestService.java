package com.xy.pi.service;

import com.xy.pi.domain.PointsOfInterest;
import com.xy.pi.repository.PointsOfInterestRepository;
import com.xy.pi.request.PointsOfInterestCreateRequest;
import com.xy.pi.request.PointsOfInterestFindByProximityRequest;
import com.xy.pi.request.PointsOfInterestUpdateRequest;
import com.xy.pi.response.PointsOfInterestListResponse;
import com.xy.pi.utils.PointsOfInterestUtils;
import com.xy.pi.verifier.MaxDistanceVerifier;
import com.xy.pi.verifier.NegativeCoordinateVerifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PointsOfInterestService {

    private final PointsOfInterestRepository pointsOfInterestRepository;
    private final PointsOfInterestUtils pointsOfInterestUtils;
    private final NegativeCoordinateVerifier negativeCoordinateVerifier;
    private final MaxDistanceVerifier maxDistanceVerifier;

    @Autowired
    public PointsOfInterestService(PointsOfInterestRepository pointsOfInterestRepository, PointsOfInterestUtils pointsOfInterestUtils, NegativeCoordinateVerifier negativeCoordinateVerifier, MaxDistanceVerifier maxDistanceVerifier) {
        this.pointsOfInterestRepository = pointsOfInterestRepository;
        this.pointsOfInterestUtils = pointsOfInterestUtils;
        this.negativeCoordinateVerifier = negativeCoordinateVerifier;
        this.maxDistanceVerifier = maxDistanceVerifier;
    }


    public PointsOfInterest create(PointsOfInterestCreateRequest request) {
        negativeCoordinateVerifier.VerifyIfThereIsNegativeCoordinateOnCreate(request);

        var pointsOfInterest = new PointsOfInterest();
        pointsOfInterestUtils.setCreateAttributes(pointsOfInterest, request);
        pointsOfInterestRepository.save(pointsOfInterest);
        return pointsOfInterest;
    }

    public PointsOfInterest details(Long id) {
        return pointsOfInterestRepository.findById(id).orElseThrow();
    }

    public Page<PointsOfInterestListResponse> list(Pageable pageable) {
        return pointsOfInterestRepository.findAllByActiveTrue(pageable).map(PointsOfInterestListResponse::new);
    }

    public Page<PointsOfInterestListResponse> listByProximities(PointsOfInterestFindByProximityRequest request, Pageable pageable) {
        negativeCoordinateVerifier.VerifyIfThereIsNegativeCoordinateOnFindByProximities(request);
        maxDistanceVerifier.VerifyIfMaxDistanceIsNegative(request.maxDistance());

        int maxDistanceX = request.xCoordinate() + request.maxDistance();
        int maxDistanceY = request.yCoordinate() + request.maxDistance();

        int minDistanceX = request.xCoordinate() - request.maxDistance();
        int minDistanceY = request.yCoordinate() - request.maxDistance();

        // Use the repository method to fetch points of interest within the specified range
        Page<PointsOfInterest> pointsOfInterest = pointsOfInterestRepository.findAllByActiveTrueAndXCoordinateBetweenAndYCoordinateBetween(
                minDistanceX, maxDistanceX, minDistanceY, maxDistanceY, pageable);

        return pointsOfInterest.map(PointsOfInterestListResponse::new);

}

    public PointsOfInterest update(PointsOfInterestUpdateRequest request) {
        negativeCoordinateVerifier.VerifyIfThereIsNegativeCoordinateOnUpdate(request);

        var pointsOfInterest = pointsOfInterestRepository.findById(request.id()).orElseThrow();

        pointsOfInterestUtils.setUpdateAttributes(pointsOfInterest, request);
        pointsOfInterestRepository.save(pointsOfInterest);
        return pointsOfInterest;
    }

    public void desactivate(Long id) {
        var pointsOfInterest = pointsOfInterestRepository.findById(id).orElseThrow();
        pointsOfInterest.setActive(false);
        pointsOfInterestRepository.save(pointsOfInterest);

    }

    public PointsOfInterest activate(Long id) {
        var pointsOfInterest = pointsOfInterestRepository.findById(id).orElseThrow();
        pointsOfInterest.setActive(true);
        pointsOfInterestRepository.save(pointsOfInterest);

        return pointsOfInterest;
    }


}
