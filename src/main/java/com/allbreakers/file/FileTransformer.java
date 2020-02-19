package com.allbreakers.file;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.util.Arrays.asList;

public class FileTransformer {
    public FileContent transform(String fileName, String valueSeparator) throws IOException {
        FileContent content = new FileContent();

        try (BufferedReader reader = read(fileName)) {
            String line;
            while ((line = reader.readLine()) != null) {
                FileLine fileLine = new FileLine();
                asList(line.split(valueSeparator)).forEach(s -> fileLine.add(new FileValue(s)));
                content.add(fileLine);
            }
        }

        return content;
    }

    public FileContent transform(String fileName, String valueSeparator, String lineSeparator) throws IOException {
        FileContent content = new FileContent();

        try (BufferedReader reader = read(fileName)) {
            asList(reader.readLine().split(lineSeparator)).forEach(lineSeparated -> {
                FileLine fileLine = new FileLine();
                asList(lineSeparated.split(valueSeparator)).forEach(s -> fileLine.add(new FileValue(s)));
                content.add(fileLine);
            });
        }

        return content;
    }

    private BufferedReader read(String fileName) {
        return new BufferedReader(new InputStreamReader(FileTransformer.class.getResourceAsStream(fileName)));
    }

}
