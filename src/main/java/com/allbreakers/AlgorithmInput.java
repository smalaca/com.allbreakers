package com.allbreakers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class AlgorithmInput {
    private ScanningFacility scanningFacility;
    private Map<Integer, Book> books = new HashMap<>();
    private List<Library> libraries = new ArrayList<>();

    void add(ScanningFacility scanningFacility) {
        this.scanningFacility = scanningFacility;
    }

    void addBook(Book book) {
        books.put(book.getId(), book);
    }

    void add(Library library) {
        libraries.add(library);
    }

    ScanningFacility getScanningFacility() {
        return scanningFacility;
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

    Book getBookById(Integer id) {
        return books.get(id);
    }
}
