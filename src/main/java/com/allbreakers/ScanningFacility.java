package com.allbreakers;

import java.util.HashSet;
import java.util.Set;

public class ScanningFacility {
    private final int availableTime;
    private final Set<Integer> books = new HashSet<>();

    public ScanningFacility(int availableTime) {
        this.availableTime = availableTime;
    }

    @Override
    public String toString() {
        return "ScanningFacility{" +
                "availableTime=" + availableTime +
                ", books=" + books +
                '}';
    }
}
