package com.allbreakers.file;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileFactory {
    public void write(String name, String content) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(name));
        writer.write(content);
        writer.close();
    }
}
