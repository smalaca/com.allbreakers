package com.allbreakers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class AlgorithmInput {
    private ScanningFacility scanningFacility;
    private HashMap<Integer, Integer> books = new HashMap<>();
    private List<Library> libraries = new ArrayList<>();

    void add(ScanningFacility scanningFacility) {
        this.scanningFacility = scanningFacility;
    }

    void addBook(int id, int score) {
        books.put(id, score);
    }

    void add(Library library) {
        libraries.add(library);
    }

    ScanningFacility getScanningFacility() {
        return scanningFacility;
    }

    HashMap<Integer, Integer> getBooks() {
        return books;
    }

    List<Library> getLibraries() {
        return libraries;
    }

    @Override
    public String toString() {
        return "AlgorithmInput{" +
                "\nscanningFacility=" + scanningFacility +
                ", \nbooks=" + books +
                ", \nlibraries=" + libraries +
                '}';
    }
}
