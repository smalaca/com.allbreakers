package com.allbreakers;

import com.allbreakers.file.FileContent;
import com.allbreakers.file.FileLine;
import com.allbreakers.file.FileReader;
import com.allbreakers.file.FileValue;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

class AlgorithmInputFactory {
    private final FileReader fileReader = new FileReader();

    AlgorithmInput create(String fileName) throws IOException {
        FileContent content = fileReader.read(fileName, " ");
        List<FileLine> lines = content.lines();

        AlgorithmInput input = new AlgorithmInput();
        // line 1
        input.add(new ScanningFacility(lines.get(0).values().get(2).asInt()));

        // line 2
        int bookId = 0;
        for (FileValue value : lines.get(1).values()) {
            input.addBook(bookId++, value.asInt());
        }

        // libraries information
        int librariesAmount = lines.get(0).values().get(1).asInt();

        for (int currentLibrary = 0; currentLibrary < librariesAmount; currentLibrary++) {
            Library library = new Library();

            FileLine libraryMetaData = lines.get(2 * currentLibrary + 2);
            library.setSignupTimeDays(libraryMetaData.getValue(1).asInt());
            library.setBooksPerDay(libraryMetaData.getValue(2).asInt());

            // books
            FileLine libraryBooks = lines.get(2 * currentLibrary + 3);
            library.addBooks(libraryBooks.values().stream().map(FileValue::asInt).collect(Collectors.toList()));

            input.add(library);
        }
        return input;
    }
}
