package com.allbreakers;

import java.io.IOException;
import java.util.List;

class AllBreakersApp {
    private static final AlgorithmInputFactory algorithmInputFactory = new AlgorithmInputFactory();

    public static void main(String[] args) throws IOException {
        process("a_example.txt");
//        process("b_read_on.txt");
//        process("c_incunabula.txt");
//        process("d_tough_choices.txt");
//        process("e_so_many_books.txt");
//        process("f_libraries_of_the_world.txt");
    }

    private static void process(String fileName) throws IOException {
        AlgorithmInput input = algorithmInputFactory.create(fileName);
        List<Library> libraries = input.getLibraries();
        ScanningFacility scanningFacility = input.getScanningFacility();

        int availableTime = scanningFacility.getAvailableTime();
        int currentDay = 0;

        fullCycle(libraries, scanningFacility, availableTime, currentDay);

        System.out.println(input.toString());
    }

    private static void fullCycle(List<Library> libraries, ScanningFacility scanningFacility, int availableTime, int currentDay) {
        // Chose the best
        Library theBest = null;
        for (Library library : libraries) {
            if (library.getSignupTimeDays() < availableTime && library.isBetterThan(theBest)) {
                theBest = library;
            }
        }
        libraries.remove(theBest);

        // signup
        currentDay += theBest.getSignupTimeDays();
        availableTime -= theBest.getSignupTimeDays();

        // remove all books to not include them again
        List<Integer> booksThatWillBeScannedTillDeadline = theBest.booksThatWillBeScannedInNext(availableTime - currentDay);
        scanningFacility.add(booksThatWillBeScannedTillDeadline);

        // remove from all libraries
        for (Library library : libraries) {
            library.removeAll(booksThatWillBeScannedTillDeadline);
        }

        // can we continue
        if (!libraries.isEmpty() && currentDay != availableTime) {
            fullCycle(libraries, scanningFacility, availableTime, currentDay);
        }
    }
}
