package com.allbreakers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ScanningFacility {
    private final int availableTime;
    private final Set<Integer> books = new HashSet<>();

    public ScanningFacility(int availableTime) {
        this.availableTime = availableTime;
    }

    int getAvailableTime() {
        return availableTime;
    }

    Set<Integer> getBooks() {
        return books;
    }

    @Override
    public String toString() {
        return "ScanningFacility{" +
                "availableTime=" + availableTime +
                ", books=" + books +
                '}';
    }

    void add(List<Integer> sortedBooksInNext) {

    }
}
