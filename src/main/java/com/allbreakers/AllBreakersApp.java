package com.allbreakers;

import com.allbreakers.file.FileFactory;
import com.allbreakers.file.FileReader;

import java.io.IOException;

class AllBreakersApp {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader();
        FileFactory fileFactory = new FileFactory();

        fileFactory.write("result/output1", fileReader.read("/files/first", ";").description());
        fileFactory.write("result/output2", fileReader.read("/files/second", " ", ";").description());
        fileFactory.write("result/output3", fileReader.read("/files/third", "&").description());
    }
}
