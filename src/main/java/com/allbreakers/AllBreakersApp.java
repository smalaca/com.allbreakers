package com.allbreakers;

import com.allbreakers.file.Output;

import java.io.IOException;
import java.util.List;

class AllBreakersApp {
    private static final AlgorithmInputFactory algorithmInputFactory = new AlgorithmInputFactory();

    public static void main(String[] args) throws IOException {
//        process("a_example.txt");
//        process("a_example.txt");
        process("b_read_on.txt");
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
        int currentDay = 1;

        Output output = new Output();
        fullCycle(libraries, availableTime, currentDay, output);

        System.out.println(output.description());
    }

    private static void fullCycle(List<Library> libraries, int availableTime, int currentDay, Output output) {

        // Chose the best
        Library theBestLibrary = null;
        for (Library library : libraries) {
            if (library.getSignupTimeDays() < availableTime && library.isBetterThan(theBestLibrary)) {
                theBestLibrary = library;
            }
        }
        libraries.remove(theBestLibrary);

        // signup
        if(theBestLibrary != null) {
            currentDay += theBestLibrary.getSignupTimeDays();
            availableTime -= theBestLibrary.getSignupTimeDays();

            // remove all books to not include them again
            List<Integer> booksThatWillBeScannedTillDeadline = theBest.booksThatWillBeScannedInNext(availableTime - currentDay);
            output.add(theBest.getId(), booksThatWillBeScannedTillDeadline);
            // wtf start
            List<Book> booksThatWillBeScannedTillDeadline = theBestLibrary.booksThatWillBeScannedInNext(availableTime - currentDay);
            scanningFacility.add(booksThatWillBeScannedTillDeadline);
            // wtf end

            // remove from all libraries
            for (Library library : libraries) {
                library.removeAll(booksThatWillBeScannedTillDeadline);
            }

            // can we continue
            if (!libraries.isEmpty() && currentDay != availableTime) {
                fullCycle(libraries, availableTime, currentDay, output);
            }
        }
    }
}
