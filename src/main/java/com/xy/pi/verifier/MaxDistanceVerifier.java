package com.xy.pi.verifier;

import com.xy.pi.exception.DistanceCoordinateException;
import org.springframework.stereotype.Component;

@Component
public class MaxDistanceVerifier {

    public void VerifyIfMaxDistanceIsNegative(int maxDistance) {
        if (maxDistance < 0 || maxDistance > 10) {
            throw new DistanceCoordinateException();
        }
    }
}
