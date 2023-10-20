package com.xy.pi.controller;

import com.xy.pi.request.PointsOfInterestCreateRequest;
import com.xy.pi.request.PointsOfInterestFindByProximityRequest;
import com.xy.pi.request.PointsOfInterestUpdateRequest;
import com.xy.pi.response.PointsOfInterestDetailsResponse;
import com.xy.pi.response.PointsOfInterestListResponse;
import com.xy.pi.service.PointsOfInterestService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/points-of-interest")
public class PointsOfInterestController {

    private final PointsOfInterestService pointsOfInterestService;
    @Autowired
    public PointsOfInterestController(PointsOfInterestService pointsOfInterestService) {
        this.pointsOfInterestService = pointsOfInterestService;
    }

    @PostMapping("/create")
    @Transactional
    public ResponseEntity create(@RequestBody @Valid PointsOfInterestCreateRequest request, UriComponentsBuilder uriBuilder) {

        var pointsOfInterest = pointsOfInterestService.create(request);
        var uri = uriBuilder.path("/points-of-interest/{id}").buildAndExpand(pointsOfInterest.getId()).toUri();
        return ResponseEntity.created(uri).body(new PointsOfInterestDetailsResponse(pointsOfInterest));


    }

    @GetMapping("/details/{id}")
    public ResponseEntity details(@PathVariable Long id) {
        var pointsOfInterest = pointsOfInterestService.details(id);
        return ResponseEntity.ok(new PointsOfInterestDetailsResponse(pointsOfInterest));
    }

    @GetMapping("/list")
    public ResponseEntity<Page<PointsOfInterestListResponse>> list(@PageableDefault(size = 10, sort = {"name"}) Pageable pageable){
        var page = pointsOfInterestService.list(pageable);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/proximities")
    public ResponseEntity<Page<PointsOfInterestListResponse>> listByProximities(@RequestBody @Valid PointsOfInterestFindByProximityRequest request, @PageableDefault(size = 10, sort = {"name"}) Pageable pageable){
        var page = pointsOfInterestService.listByProximities(request, pageable);
        return ResponseEntity.ok(page);

    }

    @PutMapping("/update")
    @Transactional
    public ResponseEntity update(@RequestBody @Valid PointsOfInterestUpdateRequest request) {
        var pointsOfInterest = pointsOfInterestService.update(request);
        return ResponseEntity.ok(new PointsOfInterestDetailsResponse(pointsOfInterest));
    }

    @PutMapping("/activate/{id}")
    @Transactional
    public ResponseEntity activate(@PathVariable Long id) {
        var pointInterest = pointsOfInterestService.activate(id);
        return ResponseEntity.ok(new PointsOfInterestDetailsResponse(pointInterest));
    }

    @DeleteMapping("/deactivate/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id) {
        pointsOfInterestService.desactivate(id);
        return ResponseEntity.noContent().build();
    }
}
