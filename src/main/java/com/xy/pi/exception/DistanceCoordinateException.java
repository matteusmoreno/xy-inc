package com.xy.pi.exception;

public class DistanceCoordinateException extends RuntimeException {

    public DistanceCoordinateException() {
        super("Distance coordinate is not allowed");
    }
}
