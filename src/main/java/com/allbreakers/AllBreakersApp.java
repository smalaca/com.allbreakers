package com.allbreakers;

import com.allbreakers.file.FileFactory;
import com.allbreakers.file.FileReader;

import java.io.IOException;

class AllBreakersApp {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader();
        FileFactory fileFactory = new FileFactory();

        fileFactory.write("output1", fileReader.read("/files/first", ";").description());
        fileFactory.write("output2", fileReader.read("/files/second", " ", ";").description());
        fileFactory.write("output3", fileReader.read("/files/third", "&").description());
    }
}
