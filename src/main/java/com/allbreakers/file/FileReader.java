package com.allbreakers.file;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import static java.util.Arrays.asList;

public class FileReader {
    public FileContent read(String fileName, String valueSeparator) throws IOException {
        FileContent content = new FileContent();

        InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream(fileName);

        System.out.println();
        InputStreamReader in = new InputStreamReader(resourceAsStream);
        try (BufferedReader reader = new BufferedReader(in)) {
            String line;
            while ((line = reader.readLine()) != null) {
                FileLine fileLine = new FileLine();
                asList(line.split(valueSeparator)).forEach(s -> fileLine.add(new FileValue(s)));
                content.add(fileLine);
            }
        }

        return content;
    }

    public FileContent read(String fileName, String valueSeparator, String lineSeparator) throws IOException {
        FileContent content = new FileContent();

        InputStream resourceAsStream = FileReader.class.getResourceAsStream(fileName);
        System.out.println();
        InputStreamReader in = new InputStreamReader(resourceAsStream);
        try (BufferedReader reader = new BufferedReader(in)) {
            asList(reader.readLine().split(lineSeparator)).forEach(lineSeparated -> {
                FileLine fileLine = new FileLine();
                asList(lineSeparated.split(valueSeparator)).forEach(s -> fileLine.add(new FileValue(s)));
                content.add(fileLine);
            });
        }

        return content;
    }

}
