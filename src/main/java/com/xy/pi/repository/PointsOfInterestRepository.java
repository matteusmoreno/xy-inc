package com.xy.pi.repository;

import com.xy.pi.domain.PointsOfInterest;
import com.xy.pi.request.PointsOfInterestFindByProximityRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PointsOfInterestRepository extends JpaRepository<PointsOfInterest, Long> {
    Page<PointsOfInterest> findAllByActiveTrue(Pageable pageable);

    @Query("SELECT p FROM PointsOfInterest p WHERE p.active = true AND p.xCoordinate BETWEEN :minX AND :maxX OR p.yCoordinate BETWEEN :minY AND :maxY")
    Page<PointsOfInterest> findAllByActiveTrueAndXCoordinateBetweenAndYCoordinateBetween(
            int minX, int maxX, int minY, int maxY, Pageable pageable);

}
