package com.xy.pi.exception;

public class NegativeCoordinateException extends RuntimeException{
    public NegativeCoordinateException() {
        super("Negative coordinate is not allowed");
    }
}
