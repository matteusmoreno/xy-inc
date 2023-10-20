package com.xy.pi.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GolbalExceptionHandler {
    @ExceptionHandler(NegativeCoordinateException.class)
    public ResponseEntity<String> handleNegativeCoordinateException(NegativeCoordinateException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler(DistanceCoordinateException.class)
    public ResponseEntity<String> handleDistanceCoordinateException(DistanceCoordinateException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
